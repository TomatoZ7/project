package com.cbh.utils;

import java.util.List;
import java.util.Map;

public class ImportResult {
	private int stateCode;
    private String message;
    private int successNum;
    private int errorNum;
    private List<Map<String, Object>> errorData;
    
	public ImportResult(int stateCode, String message, int successNum, int errorNum, List<Map<String, Object>> errorData) {
		super();
		this.stateCode = stateCode;
		this.message = message;
		this.successNum = successNum;
		this.errorNum = errorNum;
		this.errorData = errorData;
	}

	public ImportResult() {
		super();
	}

	public int getStateCode() {
		return stateCode;
	}

	public void setStateCode(int stateCode) {
		this.stateCode = stateCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getErrorNum() {
		return errorNum;
	}

	public void setErrorNum(int errorNum) {
		this.errorNum = errorNum;
	}

	public Object getErrorData() {
		return errorData;
	}

	public void setErrorData(List<Map<String, Object>> errorData) {
		this.errorData = errorData;
	}

	public int getSuccessNum() {
		return successNum;
	}

	public void setSuccessNum(int successNum) {
		this.successNum = successNum;
	}
}
