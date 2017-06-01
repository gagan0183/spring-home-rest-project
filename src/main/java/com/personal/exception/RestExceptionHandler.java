package com.personal.exception;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class RestExceptionHandler {

	@Inject
	private MessageSource messageSource;

	@ExceptionHandler(PostBookException.class)
	public ResponseEntity<?> handlePostBookException(PostBookException postBookException, HttpServletRequest request) {
		Errordetail errordetail = new Errordetail();
		errordetail.setTimeStamp(new Date().getTime());
		errordetail.setStatus(HttpStatus.BAD_REQUEST.value());
		errordetail.setTitle("unable to post book");
		errordetail.setDetail(postBookException.getMessage());
		errordetail.setDeveloperMessage(postBookException.getClass().getName());
		return new ResponseEntity<>(errordetail, null, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PostVideoException.class)
	public ResponseEntity<?> handlePostVideoException(PostVideoException postVideoException,
			HttpServletRequest request) {
		Errordetail errordetail = new Errordetail();
		errordetail.setTimeStamp(new Date().getTime());
		errordetail.setStatus(HttpStatus.BAD_REQUEST.value());
		errordetail.setTitle("unable to post video");
		errordetail.setDetail(postVideoException.getMessage());
		errordetail.setDeveloperMessage(postVideoException.getClass().getName());
		return new ResponseEntity<>(errordetail, null, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PostCertificationException.class)
	public ResponseEntity<?> handlePostCertificationException(PostCertificationException postCertficationException,
			HttpServletRequest request) {
		Errordetail errordetail = new Errordetail();
		errordetail.setTimeStamp(new Date().getTime());
		errordetail.setStatus(HttpStatus.BAD_REQUEST.value());
		errordetail.setTitle("unable to post certification");
		errordetail.setDetail(postCertficationException.getMessage());
		errordetail.setDeveloperMessage(postCertficationException.getClass().getName());
		return new ResponseEntity<>(errordetail, null, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PostProjectException.class)
	public ResponseEntity<?> handlePostProjectException(PostProjectException postProjectException,
			HttpServletRequest request) {
		Errordetail errordetail = new Errordetail();
		errordetail.setTimeStamp(new Date().getTime());
		errordetail.setStatus(HttpStatus.BAD_REQUEST.value());
		errordetail.setTitle("unable to post certification");
		errordetail.setDetail(postProjectException.getMessage());
		errordetail.setDeveloperMessage(postProjectException.getClass().getName());
		return new ResponseEntity<>(errordetail, null, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(PostVideotutorialException.class)
	public ResponseEntity<?> handlePostVideotutorialException(PostVideotutorialException postVideotutorialException,
			HttpServletRequest request) {
		Errordetail errordetail = new Errordetail();
		errordetail.setTimeStamp(new Date().getTime());
		errordetail.setStatus(HttpStatus.BAD_REQUEST.value());
		errordetail.setTitle("unable to post video tutorial");
		errordetail.setDetail(postVideotutorialException.getMessage());
		errordetail.setDeveloperMessage(postVideotutorialException.getClass().getName());
		return new ResponseEntity<>(errordetail, null, HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(VideoNotFoundException.class)
	public ResponseEntity<?> handleVideonotfoundException(VideoNotFoundException videoNotFoundException,
			HttpServletRequest request) {
		Errordetail errordetail = new Errordetail();
		errordetail.setTimeStamp(new Date().getTime());
		errordetail.setStatus(HttpStatus.NOT_FOUND.value());
		errordetail.setTitle("unable to find video");
		errordetail.setDetail(videoNotFoundException.getMessage());
		errordetail.setDeveloperMessage(videoNotFoundException.getClass().getName());
		return new ResponseEntity<>(errordetail, null, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleValidationError(MethodArgumentNotValidException methodArgumentNotValidException,
			HttpServletRequest request) {
		Errordetail errordetail = new Errordetail();
		errordetail.setTimeStamp(new Date().getTime());
		errordetail.setStatus(HttpStatus.BAD_REQUEST.value());
		String requestPath = (String) request.getAttribute("javax.servlet.error.request_uri");
		if (requestPath == null) {
			requestPath = request.getRequestURI();
		}
		errordetail.setTitle("Validation error");
		errordetail.setDetail("Input validator");
		errordetail.setDeveloperMessage(methodArgumentNotValidException.getClass().getName());
		List<FieldError> fieldErrors = methodArgumentNotValidException.getBindingResult().getFieldErrors();
		for (FieldError fieldError : fieldErrors) {
			List<ValidationError> validationErrors = errordetail.getValidationErrors().get(fieldError.getField());
			if (validationErrors == null) {
				validationErrors = new ArrayList<>();
				errordetail.getValidationErrors().put(fieldError.getField(), validationErrors);
			}
			ValidationError validationError = new ValidationError();
			validationError.setCode(fieldError.getCode());
			validationError.setMessage(messageSource.getMessage(fieldError, null));
			validationErrors.add(validationError);
		}
		return new ResponseEntity<>(errordetail, null, HttpStatus.BAD_REQUEST);
	}
}
