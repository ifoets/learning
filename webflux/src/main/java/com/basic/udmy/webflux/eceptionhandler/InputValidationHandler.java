package com.basic.udmy.webflux.eceptionhandler;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.basic.udmy.webflux.dto.ValidationResponse;
import com.basic.udmy.webflux.exception.InputValidationException;

@ControllerAdvice
public class InputValidationHandler {

	@ExceptionHandler(InputValidationException.class)
	public ResponseEntity<ValidationResponse> hadleException(InputValidationException ex) {

		ValidationResponse response = new ValidationResponse(ex.getErrorcode(), ex.getInput(), ex.getMessage());
		return ResponseEntity.badRequest()
		        .body(response);
	}
}
