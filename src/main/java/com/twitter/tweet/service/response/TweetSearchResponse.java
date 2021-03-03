package com.twitter.tweet.service.response;

import java.io.Serializable;
import java.time.LocalDateTime;

public class TweetSearchResponse implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 7413591243632235628L;

	private String message;

	private LocalDateTime tweetTime;

	private long id;

	private String tweeterId;

	public TweetSearchResponse() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public LocalDateTime getTweetTime() {
		return tweetTime;
	}

	public void setTweetTime(LocalDateTime tweetTime) {
		this.tweetTime = tweetTime;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getTweeterId() {
		return tweeterId;
	}

	public void setTweeterId(String tweeterId) {
		this.tweeterId = tweeterId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
