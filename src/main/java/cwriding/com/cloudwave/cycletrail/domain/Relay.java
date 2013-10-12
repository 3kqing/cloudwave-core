package com.cloudwave.cycletrail.domain;

import java.util.Date;

import com.cloudwave.fwapp.base.domain.AbstractDomain;
import com.cloudwave.fwapp.module.domain.User;

/**
 * 转发  实体类
 * @author DolphinBoy
 * @date 2013-8-23
 */
public class Relay extends AbstractDomain {
	private static final long serialVersionUID = -4625028862529199355L;
	
	private CtTripMessage travelMessage;
	private String content;
	private User user;
	private Date sendTime;
	
	
	public CtTripMessage getTravelMessage() {
		return travelMessage;
	}
	public void setTravelMessage(CtTripMessage travelMessage) {
		this.travelMessage = travelMessage;
	}
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
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
}
