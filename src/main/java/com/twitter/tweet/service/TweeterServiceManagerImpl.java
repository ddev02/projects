package com.twitter.tweet.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import com.twitter.cache.ProxyMessagingLayer;
import com.twitter.entity.user.User;
import com.twitter.exception.InvalidTweeterId;
import com.twitter.tweet.TweetMessage;
import com.twitter.tweet.TweetValidator;
import com.twitter.tweet.service.response.TweetResponse;
import com.twitter.user.repository.TweetMessageRepository;
import com.twitter.user.repository.UserRepository;

public class TweeterServiceManagerImpl implements TweeterServiceManager {

	private ProxyMessagingLayer messagingLayer;
	@Autowired
	private TweetMessageRepository tweetMessageRepository;
	@Autowired
	private TweetValidator<String> textMessageValidator;
	@Autowired
	private UserRepository userRepository;

	public TweeterServiceManagerImpl(ProxyMessagingLayer messagingLayer) {
		super();
		this.messagingLayer = messagingLayer;
	}

	public TweetResponse tweet(TweetMessage tweet) {
		TweetResponse tweetResponse = null;
		try {
			User user = userRepository.findByTweeterId(tweet.getTweeterId());
			if (user == null)
				throw new InvalidTweeterId(tweet.getTweeterId(), "Invalid Tweeter Id");
		} catch (Exception ex) {
			tweetResponse = new TweetResponse(tweet.getId(), "failed");
			tweetResponse.setErrorCode(500);
			tweetResponse.setError(ex.getMessage());
			return tweetResponse;
		}

		if (tweet != null && textMessageValidator.isValidTweet(tweet.getMessage())) {

			tweetResponse = messagingLayer.publish(tweet);
		}
		return tweetResponse;
	}

	public List<TweetMessage> search(String searchString) {

		List<TweetMessage> findByMessageLike = tweetMessageRepository.findByMessageLike(searchString);

		return findByMessageLike;
	}

	public List<TweetMessage> loadUserTweets(String tweeterId) {
		List<TweetMessage> messages = tweetMessageRepository.findByTweeterId(tweeterId);
		return messages;
	}

	public List<TweetMessage> loadAllTweets(Integer pageNo, Integer pageSize) {

		Pageable paging = PageRequest.of(pageNo, pageSize);

		Page<TweetMessage> pagedResult = tweetMessageRepository.findAll(paging);

		if (pagedResult.hasContent()) {
			return pagedResult.getContent();
		} else {
			return new ArrayList<TweetMessage>();
		}

	}

	public ProxyMessagingLayer getMessagingLayer() {
		return messagingLayer;
	}

	public void setMessagingLayer(ProxyMessagingLayer messagingLayer) {
		this.messagingLayer = messagingLayer;
	}

	public TweetValidator<String> getTextMessageValidator() {
		return textMessageValidator;
	}

	public void setTextMessageValidator(TweetValidator<String> textMessageValidator) {
		this.textMessageValidator = textMessageValidator;
	}

	public TweetMessageRepository getTweetMessageRepository() {
		return tweetMessageRepository;
	}

	public void setTweetMessageRepository(TweetMessageRepository tweetMessageRepository) {
		this.tweetMessageRepository = tweetMessageRepository;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

}
