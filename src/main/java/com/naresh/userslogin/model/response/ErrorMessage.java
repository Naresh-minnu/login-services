package com.naresh.userslogin.model.response;

import java.util.Date;

public class ErrorMessage {

	private Date timestamp;
	private String messaage;
	
	public ErrorMessage(Date timestamp, String messaage) {
		super();
		this.timestamp = timestamp;
		this.messaage = messaage;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getMessaage() {
		return messaage;
	}
	public void setMessaage(String messaage) {
		this.messaage = messaage;
	}
	
	
}
