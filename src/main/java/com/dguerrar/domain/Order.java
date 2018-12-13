package com.dguerrar.domain;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.List;

import com.dguerrar.domain.base.BaseObject;
import com.fasterxml.jackson.annotation.JsonProperty;
/**
 * modeles a Magento test order
 * 
 * 
 * @author david
 *
 */
public class Order extends BaseObject implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7538277447401056136L;
	
	@JsonProperty("id")
	private Long id;
	
	
	@JsonProperty("store_id")
	private Long store_id;
	
	
	@JsonProperty("lines")
	private List<Line> lines;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Long getStore_id() {
		return store_id;
	}
	public void setStore_id(Long store_id) {
		this.store_id = store_id;
	}
	public List<Line> getLines() {
		return lines;
	}
	public void setLines(List<Line> lines) {
		this.lines = lines;
	}
	public Order() {
		super();
		// TODO Auto-generated constructor stub
	}

	


	
	
	
	
}
