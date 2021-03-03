package com.twitter.user.service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;

import com.twitter.entity.user.Follower;
import com.twitter.entity.user.User;
import com.twitter.exception.InvalidTweeterId;
import com.twitter.tweet.service.response.BaseResponse;
import com.twitter.user.repository.FollowerRepository;
import com.twitter.user.repository.UserRepository;

public class UserRegistrationServiceManagerImpl implements UserRegistrationServiceManager {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private FollowerRepository followerRepository;

	@Override
	public UserRegistrationResponse create(User user) {
		UserRegistrationResponse response = null;
		try {

			userRepository.save(user);
			response = new UserRegistrationResponse("Sucess", user.getTweeterId());
			response.setErrorCode(0);
		} catch (DataIntegrityViolationException ex) {
			response = new UserRegistrationResponse("Fail", user.getTweeterId());
			response.setErrorCode(501);
			response.setError("Tweeter Id being used by other user, please use different");

		} catch (Exception ex) {
			response = new UserRegistrationResponse("Fail", user.getTweeterId());
			response.setErrorCode(500);
			response.setError(ex.getMessage());
		}
		return response;
	}

	public UserRepository getUserRepository() {
		return userRepository;
	}

	public void setUserRepository(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	@Override
	public Iterable<User> listAllUser() {

		return userRepository.findAll();
	}

	@Override
	public UserSearchResponse searchUser(String tweeterId) {
		UserSearchResponse userSearchResponse = null;
		User user = userRepository.findByTweeterIdIgnoreCase(tweeterId);
		ArrayList<User> users = new ArrayList<>();
		users.add(user);
		userSearchResponse = new UserSearchResponse(users);
		return userSearchResponse;
	}

	@Override
	public BaseResponse addFollower(String tweeterId, String followerId) {

		User user = userRepository.findByTweeterIdIgnoreCase(tweeterId);
		if (user == null)
			try {
				throw new InvalidTweeterId(tweeterId, "Invalid Tweeter Id");
			} catch (InvalidTweeterId e) {
				BaseResponse tweetResponse = new BaseResponse();
				tweetResponse.setErrorCode(500);
				tweetResponse.setError(e.getMessage());
				return tweetResponse;
			}

		User followerUser = userRepository.findByTweeterIdIgnoreCase(followerId);
		if (followerUser == null)
			try {
				throw new InvalidTweeterId(tweeterId, "Invalid follower Id");
			} catch (InvalidTweeterId e) {
				BaseResponse tweetResponse = new BaseResponse();
				tweetResponse.setErrorCode(500);
				tweetResponse.setError(e.getMessage());
				return tweetResponse;
			}

		Follower follower = followerRepository.findByUserIdAndFollowerId(user.getId(), followerUser.getId());

		if(follower != null){
			
			BaseResponse tweetResponse = new BaseResponse();
			tweetResponse.setErrorCode(1000);
			tweetResponse.setError("Already following ");
			return tweetResponse;
		}
			
		
		follower = new Follower();
		follower.setFollowerId(followerUser.getId());
		follower.setUserId(user.getId());
		follower.setDateOfFollowing(LocalDateTime.now());
		followerRepository.save(follower);
		return new BaseResponse();
	}

	public FollowerRepository getFollowerRepository() {
		return followerRepository;
	}

	public void setFollowerRepository(FollowerRepository followerRepository) {
		this.followerRepository = followerRepository;
	}

	@Override
	public FollowerResponse fetchFollowers(String tweeterId) {
		FollowerResponse tweetResponse = null;
		User user = userRepository.findByTweeterIdIgnoreCase(tweeterId);
		if (user == null)
			try {
				throw new InvalidTweeterId(tweeterId, "Invalid Tweeter Id");
			} catch (InvalidTweeterId e) {
				tweetResponse = new FollowerResponse();
				tweetResponse.setErrorCode(500);
				tweetResponse.setError(e.getMessage());
				return tweetResponse;
			}
		tweetResponse = new FollowerResponse(user);
		return tweetResponse;
	}

}
