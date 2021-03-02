package com.twitter.entity.user;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.twitter.tweet.TweetMessage;
import com.twitter.user.UserStatusDetail;

@Entity
@Table(name = "USER_INFO")
public class User implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue
	@Column(name = "user_id", nullable = false)
	private long id;
	@Column(name = "Full_Name", length = 64, nullable = false)
	private String name;
	@Column(name = "email", length = 30, nullable = false)
	private String email;
	@Column(name = "tweeter_id", length = 64, nullable = false)
	private String tweeterId;
	@OneToMany(mappedBy = "tweeterId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	// private List<Tweet<Object>> tweets;
	private List<TweetMessage> tweets;
	@OneToMany(mappedBy = "followerId", fetch = FetchType.LAZY, cascade = CascadeType.ALL)

	private List<Follower> followers;
	@Transient
	private UserStatusDetail userStatusDetail;

	@Column(name = "joining_Date", nullable = false)
	private LocalDateTime joiningDate;

	@Column(name = "last_Tweet_Date")
	private LocalDateTime lastTweetDate;

	public User(String name, String email, String tweeterId) {
		super();

		this.name = name;
		this.email = email;
		this.tweeterId = tweeterId;
	}

	public UserStatusDetail getUserStatusDetail() {
		return userStatusDetail;
	}

	public void setUserStatusDetail(UserStatusDetail userStatusDetail) {
		this.userStatusDetail = userStatusDetail;
	}

	public LocalDateTime getLastTweetDate() {
		return lastTweetDate;
	}

	public void setLastTweetDate(LocalDateTime lastTweetDate) {
		this.lastTweetDate = lastTweetDate;
	}

	public long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String getEmail() {
		return email;
	}

	public String getTweeterId() {
		return tweeterId;
	}

	public List<TweetMessage> getTweets() {
		return tweets;
	}

	public List<Follower> getFollowers() {
		return followers;
	}

	public LocalDateTime getJoiningDate() {
		return joiningDate;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((tweeterId == null) ? 0 : tweeterId.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		User other = (User) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		if (tweeterId == null) {
			if (other.tweeterId != null)
				return false;
		} else if (!tweeterId.equals(other.tweeterId))
			return false;
		return true;
	}

	public void addTweet(TweetMessage tweet) {

		this.tweets.add(tweet);
	}

	public void setId(long id) {
		this.id = id;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setTweeterId(String tweeterId) {
		this.tweeterId = tweeterId;
	}

	public void setTweets(List<TweetMessage> tweets) {
		this.tweets = tweets;
	}

	public void setFollowers(List<Follower> followers) {
		this.followers = followers;
	}

	public void setJoiningDate(LocalDateTime joiningDate) {
		this.joiningDate = joiningDate;
	}

}
