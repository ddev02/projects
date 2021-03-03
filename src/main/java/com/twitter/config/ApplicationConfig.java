package com.twitter.config;

import java.util.concurrent.ConcurrentLinkedQueue;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.twitter.cache.ProxyMessagingLayer;
import com.twitter.cache.TweetDBConnector;
import com.twitter.tweet.TextMessageValidator;
import com.twitter.tweet.TweetMessage;
import com.twitter.tweet.TweetValidator;
import com.twitter.tweet.service.TweeterServiceManager;
import com.twitter.tweet.service.TweeterServiceManagerImpl;
import com.twitter.user.service.UserRegistrationServiceManager;
import com.twitter.user.service.UserRegistrationServiceManagerImpl;

@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	public TweeterServiceManager tweeterServiceManager() {

		ConcurrentLinkedQueue<TweetMessage> queue = new ConcurrentLinkedQueue<>();
		ProxyMessagingLayer messagingLayer = new ProxyMessagingLayer(queue);
		// TweetDBConnector dbConnector = new TweetDBConnector();
		messagingLayer.addObserver(tweetDBConnector());
		return new TweeterServiceManagerImpl(messagingLayer);
	}

	@Bean
	public TweetDBConnector tweetDBConnector() {

		return new TweetDBConnector();
	}

	@Bean
	public TweetValidator<String> textMessageValidator() {

		return new TextMessageValidator();
	}

	@Bean
	public UserRegistrationServiceManager userRegistrationServiceManager() {

		return new UserRegistrationServiceManagerImpl();
	}
}
