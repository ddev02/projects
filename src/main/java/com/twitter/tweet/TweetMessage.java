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

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;

@Entity
@Table(name = "Tweet")
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class TweetMessage implements Serializable, Comparable<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2396615146633958992L;

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
//	@Transient
//	private TweetValidator<String> tweetValidator = new TextMessageValidator();

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

//	public TweetValidator<String> getTweetValidator() {
//		return tweetValidator;
//	}
//
//	public void setTweetValidator(TweetValidator<String> tweetValidator) {
//		this.tweetValidator = tweetValidator;
//	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

//	public boolean isValidTweet() {
//
//		return getTweetValidator().isValidTweet(this.message);
//	}

	@Override
	public int compareTo(String o) {

		return this.message.compareTo(o);
	}

}
