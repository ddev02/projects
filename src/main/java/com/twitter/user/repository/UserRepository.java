package com.twitter.user.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.twitter.entity.user.User;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")

public interface UserRepository extends PagingAndSortingRepository<User, Long> {

	public User findByTweeterId(String tweeterId);
	public User findByTweeterIdIgnoreCase(String tweeterId);
	
}
