package com.twitter.user.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.twitter.tweet.TweetMessage;
@Repository
public interface TweetMessageRepository extends CrudRepository<TweetMessage, Long> {
	
	 public TweetMessage findByMessage(String message); 
}
