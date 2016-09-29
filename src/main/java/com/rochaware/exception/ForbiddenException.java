package com.rochaware.exception;



/**
 * The Class ForbiddenException.
 */
public class ForbiddenException extends ServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8710384907608499138L;

	/**
	 * Instantiates a new forbidden exception.
	 */
	public ForbiddenException() {
		super("");
		
	}


	/**
	 * Instantiates a new forbidden exception.
	 *
	 * @param message the message
	 */
	public ForbiddenException(String message) {
		super(message);
		
	}

}
