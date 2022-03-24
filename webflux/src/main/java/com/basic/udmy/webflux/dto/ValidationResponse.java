package com.basic.udmy.webflux.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@Builder
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class ValidationResponse {

	private int errrorCode;

	private int input;

	private String message;

	public ValidationResponse() {

	}

	public ValidationResponse(int errrorCode, int input, String message) {
		super();
		this.errrorCode = errrorCode;
		this.input = input;
		this.message = message;
	}

	@Override
	public String toString() {
		return "ValidationResponse [errrorCode=" + errrorCode + ", input=" + input + ", message=" + message + "]";
	}

}
