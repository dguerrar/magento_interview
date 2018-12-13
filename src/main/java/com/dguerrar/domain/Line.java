package com.dguerrar.domain;

import java.io.Serializable;
import java.math.BigInteger;

import com.dguerrar.domain.base.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * modeles a Magento test order line
 * 
 * 
 * @author david
 *
 */
public class Line extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6854127210289053643L;
	
	
	@JsonProperty("line_number")
	private Long line_number;
	@JsonProperty("sku")
	private String sku;
	
	
	public Long getLine_number() {
		return line_number;
	}
	public void setLine_number(Long line_number) {
		this.line_number = line_number;
	}
	public String getSku() {
		return sku;
	}
	public void setSku(String sku) {
		this.sku = sku;
	}

	
	
	
	public Line() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Line(Long line_number, String sku) {
		super();
		this.line_number = line_number;
		this.sku = sku;
	}

	
	
	
	
	
}
