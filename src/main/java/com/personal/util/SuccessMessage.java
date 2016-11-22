package com.personal.util;

public class SuccessMessage {
	private int statusCode;
	private String successMessage;

	public SuccessMessage() {

	}

	public SuccessMessage(int statusCode, String successMessage) {
		super();
		this.statusCode = statusCode;
		this.successMessage = successMessage;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getSuccessMessage() {
		return successMessage;
	}

	public void setSuccessMessage(String successMessage) {
		this.successMessage = successMessage;
	}
}
