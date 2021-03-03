package com.twitter.entity.user;

import java.io.Serializable;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Follower")

public class Follower implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "follower_id", length = 64, nullable = false)
	private long followerId;

	@Column(name = "tweeter_id", length = 64, nullable = false)
	private long userId;
	@Column(name = "date_Of_Following", nullable = false)
	private LocalDateTime dateOfFollowing;

	public Follower() {
		super();

	}

	public long getFollowerId() {
		return followerId;
	}

	public void setFollowerId(long followerId) {
		this.followerId = followerId;
	}

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public LocalDateTime getDateOfFollowing() {
		return dateOfFollowing;
	}

	public void setDateOfFollowing(LocalDateTime dateOfFollowing) {
		this.dateOfFollowing = dateOfFollowing;
	}

}
