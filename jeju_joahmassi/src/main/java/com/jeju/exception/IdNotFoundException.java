package com.jeju.exception;

public class IdNotFoundException extends Exception {

	private Object data;
	
	public IdNotFoundException(String msg) {
		super(msg);
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
	
}
