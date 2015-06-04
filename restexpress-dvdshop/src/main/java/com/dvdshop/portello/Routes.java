package com.dvdshop.portello;

import org.jboss.netty.handler.codec.http.HttpMethod;

import com.dvdshop.portello.config.Configuration;
import com.strategicgains.restexpress.RestExpress;

public abstract class Routes {
	public static void define(Configuration config, RestExpress server) {

		/* add DVD */
		server.uri("/addDVD", config.getDvdController())
				.action("addDVD", HttpMethod.POST).name("addDVD");

		/* add DVD Copy */
		server.uri("/addCopyDVD", config.getDvdController())
				.action("addCopyDVD", HttpMethod.POST).name("addCopyDVD");

		/* update DVD Copy */
		server.uri("/updateCopyDVD", config.getDvdController())
				.action("updateCopyDVD", HttpMethod.POST).name("updateCopyDVD");

		/* search DVD Copies */
		server.uri("/getCopyDVDList", config.getDvdController())
				.action("getCopyDVDList", HttpMethod.GET)
				.name("getCopyDVDList");

		/* get User Login */
		server.uri("/getUser", config.getUserController())
				.action("getUser", HttpMethod.POST).name("getUser");

		/* add User */
		server.uri("/addUser", config.getUserController())
				.action("addUser", HttpMethod.POST).name("addUser");

		/* search DVD */
		server.uri("/getDVDList", config.getDvdController())
				.action("getDVDList", HttpMethod.GET).name("getDVDList");

		/* add Booking */
		server.uri("/addBooking", config.getBookingController())
				.action("addBooking", HttpMethod.POST).name("addBooking");

		/* get Booking */
		server.uri("/getBooking", config.getBookingController())
				.action("getBooking", HttpMethod.GET).name("getBooking");

	}
}
