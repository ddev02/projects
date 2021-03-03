package com.twitter.tweet;

public class TextMessageValidator implements TweetValidator<String> {

	@Override
	public boolean isValidTweet(String message) {

		if (message == null)
			return false;
		if (message.length() > 28)
			return false;
		return true;
	}

}
