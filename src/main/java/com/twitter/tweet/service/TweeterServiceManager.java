package com.twitter.tweet.service;

import java.util.List;

import com.twitter.tweet.TweetMessage;
import com.twitter.tweet.service.response.TweetResponse;

public interface TweeterServiceManager {

	public TweetResponse tweet(TweetMessage tweet);

	public List<TweetMessage> search(String searchString);

	public List<TweetMessage> loadUserTweets(String tweeterId);

	public List<TweetMessage> loadAllTweets(Integer pageNo, Integer pageSize);
}
