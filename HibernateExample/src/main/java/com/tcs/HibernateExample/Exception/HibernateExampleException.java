package com.tcs.HibernateExample.Exception;

public class HibernateExampleException extends Exception {

	private static final long serialVersionUID = 101L;

	/**
	 * 
	 */
	public HibernateExampleException() {
	}

	/**
	 * @param message
	 * @param cause
	 */
	public HibernateExampleException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param cause
	 */
	public HibernateExampleException(Throwable cause) {
		super(cause);
	}

}
