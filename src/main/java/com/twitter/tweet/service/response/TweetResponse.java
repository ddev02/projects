package com.twitter.tweet.service.response;

public class TweetResponse extends BaseResponse {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1675234227030301475L;
	private long messageId;
	private String responseCode;

	public TweetResponse(long messageId, String responseCode) {
		super();
		this.messageId = messageId;
		this.responseCode = responseCode;
	}

	public long getMessageId() {
		return messageId;
	}

	public String getResponseCode() {
		return responseCode;
	}

}
