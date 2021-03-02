package com.twitter.tweet;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "Tweet")
public class TweetMessage implements Serializable {

	@Column(name = "message", nullable = false)
	private String message;

	@Column(name = "tweet_Time", nullable = false)
	private LocalDateTime tweetTime;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "tweet_id", unique = true, nullable = false)
	private long id;

	@Column(name = "tweeter_id", length = 64, nullable = false)
	private String tweeterId;
	@Transient
	private TweetValidator tweetValidator;

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

	public TweetValidator getTweetValidator() {
		return tweetValidator;
	}

	public void setTweetValidator(TweetValidator tweetValidator) {
		this.tweetValidator = tweetValidator;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public boolean isValidTweet() {

		return getTweetValidator().isValidTweet();
	}

}
