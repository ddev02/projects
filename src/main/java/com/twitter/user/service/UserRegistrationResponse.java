package com.twitter.user.service;

import com.twitter.tweet.service.response.BaseResponse;

public class UserRegistrationResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7437215683930440703L;
	/**
	 * 
	 */

	private String status;
	private String tweeterId;

	public UserRegistrationResponse(String status, String tweeterId) {

		this.status = status;
		this.tweeterId = tweeterId;
	}

	public String getStatus() {
		return status;
	}

	public String getTweeterId() {
		return tweeterId;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setTweeterId(String tweeterId) {
		this.tweeterId = tweeterId;
	}

}
