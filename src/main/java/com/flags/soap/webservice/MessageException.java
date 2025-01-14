package com.flags.soap.webservice;

public class MessageException extends Exception {
	
	private Message fault;

	//Constructor
	public MessageException(String message) {
		super(message);
		
	}
	
	public MessageException(String message, Message fault) {
		super(message);
		this.fault = fault;
	}

	public Message getFault() {
		return fault;
	}
}
