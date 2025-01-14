package com.flags.soap.webservice;

public class Welcome {
	private String mCode;
	private String message;
	
	public String getmCode() {
		return mCode;
	}
	public void setmCode(String mCode) {
		this.mCode = mCode;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "Welcome [mCode=" + mCode + ", message=" + message + "]";
	}
}
