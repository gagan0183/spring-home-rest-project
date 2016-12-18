package com.personal.exception;

public class VideoNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -6562764498496599936L;

	public VideoNotFoundException(String message) {
		super(message);
	}
}
