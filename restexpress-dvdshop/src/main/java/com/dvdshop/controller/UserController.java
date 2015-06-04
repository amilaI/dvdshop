package com.dvdshop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dvdshop.model.User;
import com.dvdshop.portello.exception.RestException;
import com.dvdshop.portello.persistence.UserRepository;
import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;

/**
 * 
 * @author Amila Iddamalgoda
 * 
 */
public class UserController {

	private static final Logger LOG = LoggerFactory
			.getLogger(UserController.class);

	private UserRepository userRepository;

	public UserController() {
		super();
		userRepository = new UserRepository();
	}

	public Response getUser(Request request, Response response)
			throws RestException {

		String userIDStr = (String) request.getQueryStringMap().get("userID");
		response = new Response();

		if (userIDStr != null) {
			int userID;
			try {
				userID = Integer.parseInt(userIDStr);
				User user = userRepository.getUser(userID);

				if (user != null) {
					response.setBody(user);
					response.setResponseCode(200);
				} else {
					response.setBody(null);
					response.setResponseCode(400);
				}

			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.setBody(null);
				response.setResponseCode(400);
			}

		} else {
			response.setBody(null);
			response.setResponseCode(400);
		}

		return response;
	}

	public Response addUser(Request request, Response response)
			throws RestException {
		response = new Response();

		String userIDStr = (String) request.getQueryStringMap().get("userID");
		String userNameStr = (String) request.getQueryStringMap().get(
				"UserName");
		String userTypeStr = (String) request.getQueryStringMap().get(
				"type");
		String password = (String) request.getQueryStringMap().get(
				"password");

		if (userIDStr != null && userNameStr != null && userTypeStr != null && password != null) {
			int userID;
			try {
				userID = Integer.parseInt(userIDStr);

				User user = new User(userNameStr, userID, userTypeStr);
				try {
					userRepository.createUser(user);
					response.setBody(user);
					response.setResponseCreated();

				} catch (Exception e) {
					response.setBody("User Creation failed");
					response.setResponseCode(400);
				}

			} catch (NumberFormatException e) {
				e.printStackTrace();
				response.setBody(null);
				response.setResponseCode(400);
			}

		} else {
			response.setBody(null);
			response.setResponseCode(400);
		}
		return response;

	}

}
