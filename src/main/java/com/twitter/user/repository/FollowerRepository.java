package com.twitter.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.twitter.entity.user.Follower;

@RepositoryRestResource(collectionResourceRel = "user", path = "user")

public interface FollowerRepository extends PagingAndSortingRepository<Follower, Long> {

	public List<Follower> findByUserId(long tweeterId);
	
	public Follower findByUserIdAndFollowerId(long userId, long followerId);

}
