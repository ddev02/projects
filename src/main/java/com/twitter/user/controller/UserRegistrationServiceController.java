package com.twitter.user.controller;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.twitter.entity.user.User;
import com.twitter.tweet.service.response.BaseResponse;
import com.twitter.user.service.FollowerResponse;
import com.twitter.user.service.UserRegistrationResponse;
import com.twitter.user.service.UserRegistrationServiceManager;
import com.twitter.user.service.UserSearchResponse;

@RestController
@RequestMapping("/user")
public class UserRegistrationServiceController {

	@Autowired
	private UserRegistrationServiceManager userRegistrationServiceManager;

	public UserRegistrationServiceController(UserRegistrationServiceManager userRegistrationServiceManager) {
		super();
		this.userRegistrationServiceManager = userRegistrationServiceManager;
	}

	@PostMapping("/create")
	public UserRegistrationResponse createUser(@RequestBody User user) {

		user.setJoiningDate(LocalDateTime.now());
		return userRegistrationServiceManager.create(user);
	}

	@GetMapping("/allUser")
	@ResponseBody
	public Iterable<User> listAllUser() {

		return userRegistrationServiceManager.listAllUser();

	}

	@GetMapping("/searchUser")
	@ResponseBody
	public UserSearchResponse listAllUser(@RequestParam(name = "tweeterId") String tweeterId) {

		return userRegistrationServiceManager.searchUser(tweeterId);

	}

	@GetMapping("/addFollower")
	@ResponseBody
	public BaseResponse addFollower(@RequestParam(name = "tweeterId") String tweeterId,
			@RequestParam(name = "followerId") String followerId) {

		return userRegistrationServiceManager.addFollower(tweeterId, followerId);

	}

	@GetMapping("/followers")
	@ResponseBody
	public FollowerResponse fetchFollowers(@RequestParam(name = "tweeterId") String tweeterId) {

		return userRegistrationServiceManager.fetchFollowers(tweeterId);

	}
}
