package com.cloudwave.trailends.domain;

import java.util.Date;

import com.cloudwave.fwapp.module.domain.User;

public class CtText extends AppDomain {
	private static final long serialVersionUID = 1L;
	
	private String content;
	private Date time;
	
	private Trip trip;
	private CtLocation location;
	private User user;
	
	
	private String timeAgo;


	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Trip getTrip() {
		return trip;
	}
	public void setTrip(Trip trip) {
		this.trip = trip;
	}
	public CtLocation getLocation() {
		return location;
	}
	public void setLocation(CtLocation location) {
		this.location = location;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getTimeAgo() {
		return timeAgo;
	}
	public void setTimeAgo(String timeAgo) {
		this.timeAgo = timeAgo;
	}
	
}
