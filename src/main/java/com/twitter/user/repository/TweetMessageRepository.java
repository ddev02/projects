package com.twitter.user.repository;

import java.util.List;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.twitter.tweet.TweetMessage;

@Repository
public interface TweetMessageRepository extends PagingAndSortingRepository<TweetMessage, Long> {

	public TweetMessage findByMessage(String message);

	public List<TweetMessage> findByMessageLike(String message);
	public List<TweetMessage> findByTweeterId(String message);
	
}
