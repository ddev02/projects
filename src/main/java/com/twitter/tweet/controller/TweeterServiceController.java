package com.twitter.tweet.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.tweet.TweetMessage;
import com.twitter.tweet.service.TweeterServiceManager;
import com.twitter.tweet.service.response.TweetResponse;
import com.twitter.tweet.service.response.TweetSearchResponse;

@RestController
@RequestMapping("/tweeter")
public class TweeterServiceController {

	private TweeterServiceManager tweeterServiceManager;

	public TweeterServiceController(TweeterServiceManager serviceManager) {
		super();
		this.tweeterServiceManager = serviceManager;
	}

	@PostMapping("/tweet")
	public TweetResponse tweet(@RequestBody TweetMessage tweet) {

		return tweeterServiceManager.tweet(tweet);

	}

	@GetMapping("/search/{searchString}")
	public TweetSearchResponse search(@PathVariable("searchString") String searchString) {
		return tweeterServiceManager.search(searchString);

	}

	public TweetSearchResponse updateHomeTimeLine(String tweeterId) {

		return tweeterServiceManager.loadUserTweets(tweeterId);
	}

	public TweeterServiceManager getTweeterServiceManager() {
		return tweeterServiceManager;
	}

	public void setTweeterServiceManager(TweeterServiceManager tweeterServiceManager) {
		this.tweeterServiceManager = tweeterServiceManager;
	}

}
