package com.rentrabbit.exceptions;

public class CarNotFoundException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public CarNotFoundException(String message) {
		super(message);
	}

}
