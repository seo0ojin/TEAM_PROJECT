package com.jeju.exception;

public class IdCheckException extends Exception{

	private Object data;
	
	public IdCheckException(String msg) {
		super(msg);
	}
	
	public Object getData() {
		return data;
	}
	
	public void setData(Object data) {
		this.data = data;
	}
}
