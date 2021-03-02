package com.twitter.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.twitter.cache.ProxyMessagingLayer;
import com.twitter.tweet.service.TweeterServiceManager;
import com.twitter.tweet.service.TweeterServiceManagerImpl;


@Configuration
@EnableJpaRepositories
@EnableTransactionManagement
public class ApplicationConfig {

	@Bean
	public TweeterServiceManager tweeterServiceManager() {
		ProxyMessagingLayer messagingLayer = new ProxyMessagingLayer();
		return new TweeterServiceManagerImpl(messagingLayer);
	}
	
}
