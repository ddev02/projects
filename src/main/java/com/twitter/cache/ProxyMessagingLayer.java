package com.twitter.cache;

import java.util.Observable;
import java.util.Queue;

import com.twitter.tweet.TweetMessage;
import com.twitter.tweet.service.response.TweetResponse;

public class ProxyMessagingLayer extends Observable {

	private Queue<TweetMessage> queue;

	public TweetResponse publish(TweetMessage tweet) {
		queue.add(tweet);
		setChanged();
		notifyObservers(tweet);

		return new TweetResponse(tweet.getId(), "sucess");
	}
}
