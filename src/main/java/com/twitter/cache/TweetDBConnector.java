package com.twitter.cache;

import java.time.LocalDateTime;
import java.util.Observable;
import java.util.Observer;

import org.springframework.beans.factory.annotation.Autowired;

import com.twitter.tweet.TweetMessage;
import com.twitter.user.repository.TweetMessageRepository;
import com.twitter.user.repository.UserRepository;

public class TweetDBConnector implements Observer {

	private TweetMessage tweet;

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private TweetMessageRepository tweeterRepository;

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public TweetMessageRepository getTweeterRepository() {
		return tweeterRepository;
	}

	public void setTweeterRepository(TweetMessageRepository tweeterRepository) {
		this.tweeterRepository = tweeterRepository;
	}

	public void update(Observable o, Object arg) {

		this.tweet = (TweetMessage) arg;
		// Cache<Object, Object> userCache =
		// CacheManager.getCacheManager().getCache("UserCache");
		//
		// User user = (User) userCache.get(tweet.getTweeterId());
		//
		// user.addTweet(tweet);

		// User user = userRepository.findByTweeterId(tweet.getTweeterId());
		// TweetMessage message = new TweetMessage();
		// message.setMessage((String) tweet.getMessage());
		// message.setTweeterId(tweet.getTweeterId());
		tweet.setTweetTime(LocalDateTime.now());
		tweeterRepository.save(tweet);

	}

}
