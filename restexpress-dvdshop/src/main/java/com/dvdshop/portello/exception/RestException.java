package com.dvdshop.portello.exception;

public class RestException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1043267806237939345L;

	public RestException() {

	}

	public RestException(String msg) {
		super(msg);
	}

	public RestException(String msg, Throwable throwable) {
		super(msg, throwable);
	}

}
