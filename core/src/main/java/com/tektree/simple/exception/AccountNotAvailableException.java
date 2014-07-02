package com.tektree.simple.exception;

public class AccountNotAvailableException extends Exception {

	private static final long serialVersionUID = 2753703430018599393L;
	
	public AccountNotAvailableException(String message) {
		super(message);
	}

}
