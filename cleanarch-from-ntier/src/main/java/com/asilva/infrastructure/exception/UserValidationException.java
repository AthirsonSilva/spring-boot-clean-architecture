package com.cleanarch.infrastructure.exception;

public class UserValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public UserValidationException(String message) {
		super(message);
	}

}
