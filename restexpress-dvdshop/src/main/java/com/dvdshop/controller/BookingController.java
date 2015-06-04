package com.dvdshop.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dvdshop.model.User;
import com.dvdshop.model.dao.BookingDao;
import com.dvdshop.model.dao.DVDCopyDao;
import com.dvdshop.portello.exception.RestException;
import com.dvdshop.portello.persistence.BookingRepository;
import com.dvdshop.portello.persistence.DVDRepository;
import com.dvdshop.portello.persistence.UserRepository;
import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;

public class BookingController {

	private static final Logger LOG = LoggerFactory
			.getLogger(UserController.class);

	private BookingRepository bookingRepository;
	private UserRepository userRepository;
	private DVDRepository dvdRepository;

	public BookingController() {

		bookingRepository = new BookingRepository();
		userRepository = new UserRepository();
		dvdRepository = new DVDRepository();

	}

	public Response addBooking(Request request, Response response)
			throws RestException {

		String copyNumber = (String) request.getQueryStringMap().get(
				"copyNumber");
		String userID = (String) request.getQueryStringMap().get("userID");
		response = new Response();

		List<DVDCopyDao> s = dvdRepository.getCopyList(Integer
				.parseInt(copyNumber));
		User user = userRepository.getUser(Integer.parseInt(userID));

		if (s != null && user != null) {
			try {
				BookingDao bookingDao = new BookingDao(
						Integer.parseInt(copyNumber), Integer.parseInt(userID));
				bookingRepository.addBooking(bookingDao);

				response.setResponseCode(200);
				response.setResponseCreated();
				response.setBody(bookingDao);

			} catch (Exception e) {
				response.setResponseCode(400);
				response.setBody(null);
			}
		} else {
			response.setResponseCode(400);
			response.setBody(null);
		}

		return response;

	}

	public Response getBooking(Request request, Response response)
			throws RestException {

		response = new Response();

		try {
			List<BookingDao> bookingDao = bookingRepository.getBookingList();

			response.setResponseCode(200);
			response.setBody(bookingDao);

		} catch (Exception e) {
			response.setResponseCode(400);
			response.setBody(null);
		}

		return response;

	}

}
