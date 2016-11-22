package com.personal.exception;

import org.springframework.hateoas.VndErrors.VndError;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleExceptionHandler {

	@ExceptionHandler(PostBookException.class)
	public VndError handlePostBookException() {
		VndError error = new VndError("", "");
		return error;
	}
}
