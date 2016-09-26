package com.rochaware.exception;


/**
 * The Class ServiceException.
 */
public class ServiceException extends Exception {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	public ServiceException() {
		super("");
		
	}


	public ServiceException(String message) {
		super(message);
		
	}


}
