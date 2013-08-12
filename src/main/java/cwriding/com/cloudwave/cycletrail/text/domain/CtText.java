package com.cloudwave.cycletrail.text.domain;

import com.cloudwave.fw.app.domain.User;
import com.cloudwave.fw.domain.AbstractDomain;

public class CtText extends AbstractDomain {
	private static final long serialVersionUID = 1L;


	private String text;
	
	private User user;

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
