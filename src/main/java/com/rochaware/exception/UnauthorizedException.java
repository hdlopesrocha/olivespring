package com.rochaware.exception;



/**
 * The Class UnauthorizedException.
 */
public class UnauthorizedException extends ServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8710384907608499138L;

	/**
	 * Instantiates a new unauthorized exception.
	 */
	public UnauthorizedException() {
		super("");
		
	}


	/**
	 * Instantiates a new unauthorized exception.
	 *
	 * @param message the message
	 */
	public UnauthorizedException(String message) {
		super(message);
		
	}

}
