package com.beimin.eveapi.exception;

public class NoAuthException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public NoAuthException() {
		super("No ApiAuth available.");
	}
}