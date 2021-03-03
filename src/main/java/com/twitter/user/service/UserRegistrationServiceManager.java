package com.twitter.user.service;

import com.twitter.entity.user.User;
import com.twitter.tweet.service.response.BaseResponse;

public interface UserRegistrationServiceManager {

	public UserRegistrationResponse create(User user);

	public Iterable<User> listAllUser();

	public UserSearchResponse searchUser(String tweeterId);

	public BaseResponse addFollower(String userId, String followerId);

	public FollowerResponse fetchFollowers(String userId);
}
