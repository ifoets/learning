package com.basic.udmy.webflux.exception;

public class InputValidationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private static final String MSG = "Allowed  range is 10-20";

	private final int errorCode = 100;

	private final int input;

	public InputValidationException() {
		super();
		this.input = 0;
		// TODO Auto-generated constructor stub
	}

	public InputValidationException(int input) {
		super(MSG);
		this.input = input;
	}

	public int getErrorcode() {
		return errorCode;
	}

	public int getInput() {
		return input;
	}

}
