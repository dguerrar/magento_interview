package com.dguerrar.domain;

import java.io.Serializable;

import com.dguerrar.domain.base.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProcessingOrder  extends BaseObject implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8783909666494784082L;
	@JsonProperty("order")
	private Order order;
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public ProcessingOrder() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	
}
