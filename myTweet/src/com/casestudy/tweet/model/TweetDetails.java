package com.casestudy.tweet.model;

public class TweetDetails {

	private Integer tid;
	private String email;
	private String content;

	public TweetDetails(String email, String content) {
		super();
		this.email = email;
		this.content = content;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

}
