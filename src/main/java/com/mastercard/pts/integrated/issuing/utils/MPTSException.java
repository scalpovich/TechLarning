package com.mastercard.pts.integrated.issuing.utils;

/**
 * created class for cryptoUtils we will throw exception from this class for
 * cryptoUtils
 * 
 * @author e058829
 *
 */
public class MPTSException extends Exception {

	private static final long serialVersionUID = 1L;

	public MPTSException(String error) {
		super(error);
		// MDESAssert.assertTrue(error, false);
	}

	public MPTSException(String message, Throwable throwable) {
		super(message, throwable);
	}
}
