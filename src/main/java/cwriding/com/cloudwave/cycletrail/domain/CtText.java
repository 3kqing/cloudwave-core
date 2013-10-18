package com.cloudwave.cycletrail.domain;

import java.util.Date;

import com.cloudwave.fwapp.base.domain.AbstractDomain;
import com.cloudwave.fwapp.module.domain.User;

public class CtText extends AbstractDomain {
	private static final long serialVersionUID = 1L;
	
	private String content;
	private Date time;
	
	private CtTravels travelNotes;
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
	public CtTravels getTravelNotes() {
		return travelNotes;
	}
	public void setTravelNotes(CtTravels travelNotes) {
		this.travelNotes = travelNotes;
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
