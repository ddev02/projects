package com.twitter.tweet;

public interface TweetValidator<T> {

	public boolean isValidTweet(T t);
}
