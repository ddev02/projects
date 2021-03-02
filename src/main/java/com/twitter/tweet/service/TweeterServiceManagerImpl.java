package com.twitter.tweet.service;

import com.twitter.cache.ProxyMessagingLayer;
import com.twitter.tweet.TweetMessage;
import com.twitter.tweet.service.response.TweetResponse;
import com.twitter.tweet.service.response.TweetSearchResponse;

public class TweeterServiceManagerImpl implements TweeterServiceManager {

	private ProxyMessagingLayer messagingLayer;

	public TweeterServiceManagerImpl(ProxyMessagingLayer messagingLayer) {
		super();
		this.messagingLayer = messagingLayer;
	}

	public TweetResponse tweet(TweetMessage tweet) {

		if (tweet != null && tweet.isValidTweet()) {

			return messagingLayer.publish(tweet);
		}
		return null;
	}

	public TweetSearchResponse search(String searchString) {
		// TODO Auto-generated method stub
		return null;
	}

	public TweetSearchResponse loadUserTweets(String tweeterId) {
		// TODO Auto-generated method stub
		return null;
	}

	public ProxyMessagingLayer getMessagingLayer() {
		return messagingLayer;
	}

	public void setMessagingLayer(ProxyMessagingLayer messagingLayer) {
		this.messagingLayer = messagingLayer;
	}

}
