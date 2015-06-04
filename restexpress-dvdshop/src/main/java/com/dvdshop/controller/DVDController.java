package com.dvdshop.controller;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.dvdshop.model.DVD;
import com.dvdshop.model.DVDCopy;
import com.dvdshop.model.dao.DVDCopyDao;
import com.dvdshop.portello.exception.RestException;
import com.dvdshop.portello.persistence.DVDRepository;
import com.strategicgains.restexpress.Request;
import com.strategicgains.restexpress.Response;

/**
 * 
 * @author Amila Iddamalgoda
 * 
 */
public class DVDController {

	private static final Logger LOG = LoggerFactory
			.getLogger(DVDController.class);

	private DVDRepository dvdRepository;

	public DVDController() {
		super();
		dvdRepository = new DVDRepository();

	}

	public Response getCopyDVDList(Request request, Response response)
			throws RestException {

		String dvdcode = (String) request.getQueryStringMap().get("dvdcode");
		response = new Response();
		response.setBody(null);
		response.setResponseCode(400);

		if (dvdcode != null) {
			List<DVD> dvdset = dvdRepository.getDVDList();

			if (dvdset != null) {

				int id = Integer.parseInt(dvdcode);

				for (DVD dvd : dvdset) {
					if (dvd.getCode() == id) {

						List<DVDCopyDao> copyList = dvdRepository
								.getCopyDVDList(id);

						if (copyList != null) {

							response.setBody(copyList);
							response.setResponseCode(200);
						}
						break;

					}
				}

			}

		}

		return response;

	}

	public Response addDVD(Request request, Response response)
			throws RestException {

		int id = 0;
		response = new Response();
		String title = (String) request.getQueryStringMap().get("title");
		String year = (String) request.getQueryStringMap().get("year");
		String actors = (String) request.getQueryStringMap().get("actors");
		String ratings = (String) request.getQueryStringMap().get("ratings");
		String definitions = (String) request.getQueryStringMap().get(
				"definitions");

		try {
			DVD dvd = new DVD(id, title, actors, Integer.parseInt(ratings),
					definitions, year);

			dvdRepository.createDVD(dvd);
			response.setResponseCreated();
			response.setBody(dvd);
			response.setResponseCode(201);

		} catch (Exception e) {
			response.setBody(null);
			response.setResponseCode(400);
		}

		return response;

	}

	public Response getDVDList(Request request, Response response)
			throws RestException {

		response = new Response();

		List<DVD> dvdset = dvdRepository.getDVDList();

		if (dvdset != null) {
			response.setBody(dvdset);
			response.setResponseCode(200);
		} else {
			response.setBody(null);
			response.setResponseCode(400);
		}
		return response;
	}

	public Response addCopyDVD(Request request, Response response)
			throws RestException {

		int id = 0;
		response = new Response();
		String copyNumber = (String) request.getQueryStringMap().get(
				"copyNumber");
		String isleNumber = (String) request.getQueryStringMap().get(
				"isleNumber");
		String shelfNumber = (String) request.getQueryStringMap().get(
				"shelfNumber");
		String code = (String) request.getQueryStringMap().get("code");

		try {
			DVDCopyDao copyDao = new DVDCopyDao(Integer.parseInt(copyNumber),
					isleNumber, shelfNumber, Integer.parseInt(code), "1");

			dvdRepository.createCopyDVD(copyDao);
			response.setResponseCreated();
			response.setBody(copyDao);
			response.setResponseCode(201);

		} catch (Exception e) {
			response.setBody(null);
			response.setResponseCode(400);
		}

		return response;

	}

	public Response updateCopyDVD(Request request, Response response)
			throws RestException {

		int id = 0;
		response = new Response();
		String copyNumber = (String) request.getQueryStringMap().get(
				"copyNumber");
		String isleNumber = (String) request.getQueryStringMap().get(
				"isleNumber");
		String shelfNumber = (String) request.getQueryStringMap().get(
				"shelfNumber");
		String code = (String) request.getQueryStringMap().get("code");

		try {
			DVDCopyDao copyDao = new DVDCopyDao();

			copyDao.setAvailable("1");
			copyDao.setCopyNumber(Integer.parseInt(copyNumber));
			copyDao.setDvdCode(Integer.parseInt(code));
			copyDao.setShelfNumber(shelfNumber);
			copyDao.setIsleNumber(isleNumber);

			dvdRepository.updateCopyDVD(copyDao);
			response.setResponseCreated();
			response.setBody(copyDao);
			response.setResponseCode(201);

		} catch (Exception e) {
			response.setBody(null);
			response.setResponseCode(400);
		}

		return response;

	}

}
