package com.twitter.exception;

public class InvalidTweeterId extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7275052860082120206L;

	private String tweeterId;

	public InvalidTweeterId(String tweeterId, String message) {
		super(message);
		this.tweeterId = message;
	}

	public InvalidTweeterId(String message, Throwable cause) {
		super(message, cause);
		this.tweeterId = message;
	}

	@Override
	public String toString() {
		return "InvalidTweeterId [message=" + tweeterId + "]";
	}

}
