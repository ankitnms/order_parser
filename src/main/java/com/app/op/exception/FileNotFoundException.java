package com.app.op.exception;

public class FileNotFoundException extends RuntimeException {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FileNotFoundException(String message, Throwable ex) {
		super(message, ex);
	}
}
