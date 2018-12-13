package com.dguerrar.domain;

import java.io.Serializable;

import com.dguerrar.domain.base.BaseObject;

public class Notification extends BaseObject implements Serializable,Comparable<Notification> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -4116903041501562022L;
	
	private String to;
	private String subject;
	private String content;
	public  Notification(String to, String subject, String content) {
		super();
		this.to = to;
		this.subject = subject;
		this.content = content;
	}
	
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public int compareTo(Notification o) {
	
		return content.compareTo(o.getContent());
	}
	
	
	

}
