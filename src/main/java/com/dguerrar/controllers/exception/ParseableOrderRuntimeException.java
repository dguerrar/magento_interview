package com.dguerrar.controllers.exception;

public class ParseableOrderRuntimeException extends Exception{

	/**
	 * 	
	 * this exceptions is reased when getting an not paseable order - HTTP error 422
	 * 
	 */
	private static final long serialVersionUID = 105223729154980805L;

	public ParseableOrderRuntimeException(String msg) {
		super(msg);
	}



}
