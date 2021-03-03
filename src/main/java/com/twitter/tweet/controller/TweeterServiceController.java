package com.twitter.tweet.controller;

import java.util.List;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.tweet.TweetMessage;
import com.twitter.tweet.service.TweeterServiceManager;
import com.twitter.tweet.service.response.TweetResponse;

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

	@GetMapping("/search")
	@ResponseBody
	public List<TweetMessage> search(@RequestParam(name = "searchString") String searchString) {

		List<TweetMessage> list = tweeterServiceManager.search(searchString);

		return list;
	}

	@GetMapping("/timeline")
	@ResponseBody
	public List<TweetMessage> updateHomeTimeLine(@RequestParam(name = "tweeterId") String tweeterId) {

		return tweeterServiceManager.loadUserTweets(tweeterId);
	}

	@GetMapping("/allTweets")
	@ResponseBody
	public List<TweetMessage> allTweets(@RequestParam(defaultValue = "0") Integer pageNo,
			@RequestParam(defaultValue = "10") Integer pageSize) {

		return tweeterServiceManager.loadAllTweets(pageNo, pageSize);
	}

	public TweeterServiceManager getTweeterServiceManager() {
		return tweeterServiceManager;
	}

	public void setTweeterServiceManager(TweeterServiceManager tweeterServiceManager) {
		this.tweeterServiceManager = tweeterServiceManager;
	}

}
