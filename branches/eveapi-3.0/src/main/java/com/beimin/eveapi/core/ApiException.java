package com.beimin.eveapi.core;

public class ApiException extends Exception {
	private static final long serialVersionUID = 1L;

	public ApiException() {
		super();
	}

	public ApiException(String msg) {
		super(msg);
	}

	public ApiException(Throwable cause) {
		super(cause);
	}

	public ApiException(String message, Throwable cause) {
		super(message, cause);
	}
}