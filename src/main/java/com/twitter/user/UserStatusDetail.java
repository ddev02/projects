package com.twitter.user;

import java.io.Serializable;

public class UserStatusDetail implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -803639518611585791L;

	private UserStatus status;

	private String statusChangeReason;

	public UserStatusDetail() {
		super();
		// TODO Auto-generated constructor stub
	}

	public UserStatusDetail(UserStatus status, String statusChangeReason) {
		super();
		this.status = status;
		this.statusChangeReason = statusChangeReason;
	}

	public UserStatus getStatus() {
		return status;
	}

	public void setStatus(UserStatus status) {
		this.status = status;
	}

	public String getStatusChangeReason() {
		return statusChangeReason;
	}

	public void setStatusChangeReason(String statusChangeReason) {
		this.statusChangeReason = statusChangeReason;
	}

}
