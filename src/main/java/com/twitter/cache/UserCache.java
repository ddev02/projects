package com.twitter.cache;

public class UserCache<Long, User> extends AbstractCache<Long, User> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public String getName() {

		return "UserCache";
	}

}
