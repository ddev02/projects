package com.twitter.entity.user;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Follower")

public class Follower implements Serializable{

	@Id
	@Column(name = "follower_id", length = 64, nullable = false)
	private String followerId;
	
	@Column(name = "tweeter_id", length = 64, nullable = false)
	private String tweeterId;

	public String getFollowerId() {
		return followerId;
	}

	public void setFollowerId(String followerId) {
		this.followerId = followerId;
	}

	public String getTweeterId() {
		return tweeterId;
	}

	public void setTweeterId(String tweeterId) {
		this.tweeterId = tweeterId;
	}

}
