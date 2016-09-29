package com.rochaware.exception;



/**
 * The Class BadRequestException.
 */
public class BadRequestException extends ServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8710384907608499135L;

	/**
	 * Instantiates a new bad request exception.
	 */
	public BadRequestException() {
		super("");
		
	}


	/**
	 * Instantiates a new bad request exception.
	 *
	 * @param message the message
	 */
	public BadRequestException(String message) {
		super(message);
		
	}
}
