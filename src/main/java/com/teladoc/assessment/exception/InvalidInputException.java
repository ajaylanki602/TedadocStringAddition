package com.teladoc.assessment.exception;


public class InvalidInputException extends RuntimeException {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -26619142254127548L;

	/**
	 * constructor
	 * @param message
	 */
	public InvalidInputException(String message){
		super(message);
	}
	
}
