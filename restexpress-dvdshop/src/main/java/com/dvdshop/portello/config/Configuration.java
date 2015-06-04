package com.dvdshop.portello.config;

import java.util.Properties;

import com.dvdshop.controller.BookingController;
import com.dvdshop.controller.DVDController;
import com.dvdshop.controller.UserController;
import com.dvdshop.portello.Constants;
import com.strategicgains.restexpress.Format;
import com.strategicgains.restexpress.RestExpress;
import com.strategicgains.restexpress.util.Environment;

public class Configuration extends Environment {
	private static final String DEFAULT_EXECUTOR_THREAD_POOL_SIZE = "20";

	private static final String PORT_PROPERTY = "port";
	private static final String DEFAULT_FORMAT_PROPERTY = "default.Format";
	private static final String BASE_URL_PROPERTY = "base.url";
	private static final String EXECUTOR_THREAD_POOL_SIZE = "executor.threadPool.size";

	private int port;
	private String defaultFormat;
	private String baseUrl;
	private int executorThreadPoolSize;

	private DVDController dvdController;
	private UserController userController;
	private BookingController bookingController;

	private CorsConfig corsConfig = null;

	@Override
	protected void fillValues(Properties p) {
		Constants.PROPERTIES = p;
		this.port = Integer.parseInt(p.getProperty(PORT_PROPERTY,
				String.valueOf(RestExpress.DEFAULT_PORT)));

		this.defaultFormat = p
				.getProperty(DEFAULT_FORMAT_PROPERTY, Format.JSON);
		this.baseUrl = p.getProperty(BASE_URL_PROPERTY, "http://localhost:"
				+ String.valueOf(port));
		this.executorThreadPoolSize = Integer.parseInt(p.getProperty(
				EXECUTOR_THREAD_POOL_SIZE, DEFAULT_EXECUTOR_THREAD_POOL_SIZE));

		this.corsConfig = new CorsConfig(p);
		configureControllers();

	}

	private void configureControllers() {
		dvdController = new DVDController();
		userController = new UserController();
		bookingController = new BookingController();
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public String getDefaultFormat() {
		return defaultFormat;
	}

	public int getPort() {
		return port;
	}

	public DVDController getDvdController() {
		return dvdController;
	}

	public UserController getUserController() {
		return userController;
	}

	public int getExecutorThreadPoolSize() {
		return executorThreadPoolSize;
	}

	public CorsConfig getCorsConfig() {
		return corsConfig;
	}

	public BookingController getBookingController() {
		return bookingController;
	}

}