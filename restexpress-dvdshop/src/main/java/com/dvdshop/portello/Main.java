package com.dvdshop.portello;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dvdshop.portello.config.Configuration;
import com.dvdshop.portello.config.CorsConfig;
import com.dvdshop.portello.postprocessor.LastModifiedHeaderPostprocessor;
import com.dvdshop.portello.serialization.ResponseProcessors;
import com.strategicgains.eventing.DomainEvents;
import com.strategicgains.eventing.EventBus;
import com.strategicgains.eventing.local.LocalEventBusBuilder;
import com.strategicgains.repoexpress.exception.DuplicateItemException;
import com.strategicgains.repoexpress.exception.InvalidObjectIdException;
import com.strategicgains.repoexpress.exception.ItemNotFoundException;
import com.strategicgains.restexpress.Format;
import com.strategicgains.restexpress.Parameters;
import com.strategicgains.restexpress.RestExpress;
import com.strategicgains.restexpress.exception.BadRequestException;
import com.strategicgains.restexpress.exception.ConflictException;
import com.strategicgains.restexpress.exception.NotFoundException;
import com.strategicgains.restexpress.pipeline.SimpleConsoleLogMessageObserver;
import com.strategicgains.restexpress.plugin.cache.CacheControlPlugin;
import com.strategicgains.restexpress.plugin.cors.CorsHeaderPlugin;
import com.strategicgains.restexpress.plugin.route.RoutesMetadataPlugin;
import com.strategicgains.restexpress.util.Environment;
import com.strategicgains.syntaxe.ValidationException;

public class Main
{
	private static final String NAME = "DVD Shop Web Service Implementation";
	private static final Logger LOG = LoggerFactory.getLogger(NAME);

	public static void main(String[] args) throws Exception
	{
		Configuration config = loadEnvironment(args);
		RestExpress server = new RestExpress()
		    .setName(NAME)
		    .setBaseUrl(config.getBaseUrl())
		    .setDefaultFormat(config.getDefaultFormat())
		    .setExecutorThreadCount(config.getExecutorThreadPoolSize())
		    .putResponseProcessor(Format.JSON, ResponseProcessors.json())
		    .putResponseProcessor(Format.XML, ResponseProcessors.xml())
            
		    .addPostprocessor(new LastModifiedHeaderPostprocessor())
		    .addMessageObserver(new SimpleConsoleLogMessageObserver());
		

		Routes.define(config, server);
		
		new RoutesMetadataPlugin()							// Support basic discoverability.
			.register(server)
			.parameter(Parameters.Cache.MAX_AGE, 86400);	// Cache for 1 day (24 hours).

		new CacheControlPlugin()							// Support caching headers.
			.register(server);

		CorsConfig cors = config.getCorsConfig();
		new CorsHeaderPlugin(cors.getOrigins())
			.exposeHeaders(cors.getExposedHeaders())
			.allowHeaders(cors.getAllowedHeaders())
			.maxAge(cors.getMaxAge())
			.register(server);

		mapExceptions(server);
		registerDomainEvents(server, config);
		server.bind(config.getPort());
		server.awaitShutdown();
	}
	
	/**
     * @param server
     */
    private static void mapExceptions(RestExpress server)
    {
    	server
	    	.mapException(ItemNotFoundException.class, NotFoundException.class)
	    	.mapException(DuplicateItemException.class, ConflictException.class)
	    	.mapException(ValidationException.class, BadRequestException.class)
	    	.mapException(InvalidObjectIdException.class, NotFoundException.class)
	    	.mapException(com.github.jmkgreen.morphia.query.ValidationException.class, BadRequestException.class);
    }

	private static void registerDomainEvents(RestExpress server, Configuration config)
	{
		EventBus localBus = new LocalEventBusBuilder()
		.build();
		DomainEvents.addBus("jvm", localBus);

		Runtime.getRuntime().addShutdownHook(new Thread()
		{
			@Override
			public void run()
			{
				DomainEvents.shutdown();
			}
		});
	}

	private static Configuration loadEnvironment(String[] args)
    throws FileNotFoundException, IOException
    {
	    if (args.length > 0)
		{
			return Environment.from(args[0], Configuration.class);
		}

	    return Environment.fromDefault(Configuration.class);
    }
}
