package com.cloudwave.trailends.domain;


/**
 * 评论  实体类
 * @author DolphinBoy
 * @date 2013-8-23
 */
public class CtDiscuss extends AppDomain {
	private static final long serialVersionUID = -4625028862529199355L;
	
	private CtTripMessage travelMessage;
	private String content;
	
	
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
}
