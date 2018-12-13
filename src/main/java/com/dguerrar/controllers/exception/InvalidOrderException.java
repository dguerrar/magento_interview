package com.dguerrar.controllers.exception;

public class InvalidOrderException extends Exception{ //400

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -3684699060648551828L;

	/**
	 * this exceptions is reased when getting invalid JSON - HTTP error 400
	 * 
	 */


	public InvalidOrderException(String msg) {
		super(msg);
	}
}
