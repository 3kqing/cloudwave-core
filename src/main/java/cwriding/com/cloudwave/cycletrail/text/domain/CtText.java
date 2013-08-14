package com.cloudwave.cycletrail.text.domain;

import com.cloudwave.fw.app.domain.User;
import com.cloudwave.fw.domain.AbstractDomain;

public class CtText extends AbstractDomain {
	private static final long serialVersionUID = 1L;


	private String content;
	
	private User user;


	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
