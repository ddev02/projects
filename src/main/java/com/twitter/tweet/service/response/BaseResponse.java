package com.twitter.tweet.service.response;

import java.io.Serializable;

public class BaseResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2102012692927507709L;
	private long errorCode;
	private String error;

	public BaseResponse() {
		super();
		
	}

	public long getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(long errorCode) {
		this.errorCode = errorCode;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
