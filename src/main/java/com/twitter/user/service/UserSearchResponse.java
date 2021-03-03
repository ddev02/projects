package com.twitter.user.service;

import java.util.List;

import com.twitter.entity.user.User;
import com.twitter.tweet.service.response.BaseResponse;

public class UserSearchResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7911676401506325458L;

	List<User> users;

	public UserSearchResponse(List<User> users) {
		super();
		this.users = users;
	}

	public List<User> getUsers() {
		return users;
	}

}
