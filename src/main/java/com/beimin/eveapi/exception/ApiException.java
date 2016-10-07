package com.beimin.eveapi.exception;

public class ApiException extends Exception {
    private static final long serialVersionUID = 1L;

    public ApiException() {
        super();
    }

    public ApiException(final String msg) {
        super(msg);
    }

    public ApiException(final Throwable cause) {
        super(cause);
    }

    public ApiException(final String message, final Throwable cause) {
        super(message, cause);
    }
}