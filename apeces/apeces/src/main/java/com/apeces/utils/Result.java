package com.apeces.utils;

import java.util.Map;

public class Result {
	private int code;
    private String message;
    private Map<String, Object> data;
    
    public Result() {
        super();
    }
    public Result(int code, String message, Map<String, Object> data) {
        super();
        this.code = code;
        this.message = message;
        this.setData(data);
    }

	public int getStateCode() {
		return code;
	}

	public void setStateCode(int stateCode) {
		this.code = stateCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public Map<String, Object> getData() {
		return data;
	}
	
	public void setData(Map<String, Object> data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Result [stateCode=" + code + ", message=" + message + ", data=" + data + "]";
	}
}
