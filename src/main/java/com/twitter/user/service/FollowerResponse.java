package com.twitter.user.service;

import com.twitter.entity.user.User;
import com.twitter.tweet.service.response.BaseResponse;

public class FollowerResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6064347918650428077L;

	private User user;

	public FollowerResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FollowerResponse(User user) {
		super();
		this.user = user;

	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
