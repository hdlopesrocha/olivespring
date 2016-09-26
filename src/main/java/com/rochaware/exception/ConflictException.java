package com.rochaware.exception;


/**
 * The Class ConflictException.
 */
public class ConflictException extends ServiceException {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = -8710384907608499138L;

	/**
	 * Instantiates a new conflict exception.
	 */
	public ConflictException() {
		super("");
	}

	/**
	 * Instantiates a new conflict exception.
	 *
	 * @param message the message
	 */
	public ConflictException(String message) {
		super(message);
	}
}
