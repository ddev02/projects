package com.twitter.tweet;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

public abstract class AbstractTweet<T> implements Tweet<T> {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Column(name = "message", nullable = false)
	private T t;
	@Temporal(TemporalType.DATE)
	@Column(name = "tweet_Time", nullable = false)
	private LocalDateTime tweetTime;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tweet_id",unique=true, nullable = false)
	private long id;

	
	@Column(name = "tweeter_id", length = 64, nullable = false)
	private String tweeterId;

	private TweetValidator tweetValidator;

	public AbstractTweet(T t, long id, String tweeterId) {
		super();
		this.t = t;
		this.tweetTime = LocalDateTime.now();
		this.id = id;
		this.tweeterId = tweeterId;
	}

	public TweetValidator getTweetValidator() {
		return tweetValidator;
	}

	public void setTweetValidator(TweetValidator tweetValidator) {
		this.tweetValidator = tweetValidator;
	}

	public T getMessage() {
		// TODO Auto-generated method stub
		return t;
	}

	public LocalDateTime getTweetTime() {
		// TODO Auto-generated method stub
		return tweetTime;
	}

	public long getId() {
		// TODO Auto-generated method stub
		return id;
	}

	public String getTweeterId() {
		// TODO Auto-generated method stub
		return tweeterId;
	}

	public boolean isValidTweet() {

		return getTweetValidator().isValidTweet(this.t);
	}

	public T getT() {
		return t;
	}

	public void setT(T t) {
		this.t = t;
	}

	public void setTweetTime(LocalDateTime tweetTime) {
		this.tweetTime = tweetTime;
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setTweeterId(String tweeterId) {
		this.tweeterId = tweeterId;
	}
}
