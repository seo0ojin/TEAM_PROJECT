package com.jeju.controller;

import java.util.HashMap;

import lombok.Data;

@Data
public class UserInfoResponse {

	private int status;
	private String message;
	private Object data;
	
	public UserInfoResponse() {
		this.status = 0;
		this.message = "";
		this.data = new HashMap();
	}
}
