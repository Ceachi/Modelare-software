package com.itinerar.exception;

public class RowNotFoundException extends RuntimeException {
	public RowNotFoundException(String message) {
		super(message);
	}
}
