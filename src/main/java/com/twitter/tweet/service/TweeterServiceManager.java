package com.twitter.tweet.service;

import com.twitter.tweet.TweetMessage;
import com.twitter.tweet.service.response.TweetResponse;
import com.twitter.tweet.service.response.TweetSearchResponse;

public interface TweeterServiceManager {

	public TweetResponse tweet(TweetMessage tweet);
	public TweetSearchResponse search(String searchString);
	public TweetSearchResponse loadUserTweets(String tweeterId);
}
