package com.sample.model;

public class Status {
	 private int code;
	 private String message;
	 private String statusType;

	 public Status() {
	 }

	 public Status(int code, String message, String statusType) {
	  this.code = code;
	  this.message = message;
	  this.statusType = statusType;
	 }

	public String getStatusType() {
		return statusType;
	}

	public void setStatusType(String statusType) {
		this.statusType = statusType;
	}

	public int getCode() {
	  return code;
	 }

	 public void setCode(int code) {
	  this.code = code;
	 }

	 public String getMessage() {
	  return message;
	 }

	 public void setMessage(String message) {
	  this.message = message;
	 }
}
