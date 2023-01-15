package net.javaguides.linepaymanagement.model;

import java.util.Date;

public class Linpay {
	
	protected int id;
	protected String url;
	protected Date time;
	
	public Linpay() {
		
	}
	
	public Linpay(int id, String url, Date time) {
		super();
		this.id = id;
		this.url = url;
		this.time = time;
	}
	
	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		
	}
	
	public String getUrl() {
		return url;
	}
	
	public void setUrl(String url) {
		this.url = url;
	}
	
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	
}
