package com.rochaware.exception;




/**
 * The Class GoneException.
 */
public class GoneException extends ServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8710384907608499138L;

	/**
	 * Instantiates a new gone exception.
	 */
	public GoneException() {
		super("");
		
	}


	/**
	 * Instantiates a new gone exception.
	 *
	 * @param message the message
	 */
	public GoneException(String message) {
		super(message);
		
	}
}
