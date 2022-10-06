package com.azaztrucking.exception;

import com.azaztrucking.model.ErrorDetail;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@ToString
public enum AzazTruckingExCodeEnum {

	MANDATORY_INPUT("AZ1", "Missing Input"),
	NOT_FOUND("AZ2", "Not Found"),
	SQL_EXCEPTION("AZ3", "SQL Exception");
	
	private String code;
	private String message;
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	
	
}
