package com.wenable.rabbit.beans;

import org.springframework.data.annotation.Id;

public class Message {
	@Id
	private String id;
	private String message;

	
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Override
	public String toString() {
		return "Message [message=" + message + "]";
	}
	
	

}
