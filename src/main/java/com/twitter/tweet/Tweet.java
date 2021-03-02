package com.twitter.tweet;

import java.io.Serializable;
import java.time.LocalDateTime;


public interface Tweet<T> extends Serializable {

	public long getId();

	public String getTweeterId();

	public T getMessage();

	public LocalDateTime getTweetTime();

	public boolean isValidTweet();

}
