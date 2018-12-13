package com.dguerrar.controllers.exception;

public class OrderLineSequenceException extends Exception{ //500

	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1250684637047152845L;

	/**
	 * this exceptions is reased when getting an order with an invalid squence line number JSON - HTTP error 400
	 * 
	 */


	public OrderLineSequenceException() {
		super();
	}

}

