package com.cloudwave.cycletrail.domain;

import java.util.Date;
import java.util.List;

import com.cloudwave.fwapp.base.domain.AbstractDomain;
import com.cloudwave.fwapp.module.domain.FileEntity;
import com.cloudwave.fwapp.module.domain.User;

/**
 * @description 旅行消息 实体类
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-22 上午10:28:23
 * TODO
 */
public class CtTravelMessage extends AbstractDomain {
	private static final long serialVersionUID = 1984117769061665519L;
	
	private String title;
	private String path;
	
	private String text;
	
	private Date sendTime;
	
	private CtTravelNotes travelNotes;
	private CtLocation location;
	private User user;
	private FileEntity file;
	
	/** 以下属性用于显示, 而不做持久化 */
	private String timeAgo;
	private int disSize = 0;
	private List<CtDiscuss> disList;
	
	
	public FileEntity getFile() {
		return file;
	}
	public void setFile(FileEntity file) {
		this.file = file;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	public Date getSendTime() {
		return sendTime;
	}
	public void setSendTime(Date sendTime) {
		this.sendTime = sendTime;
	}
	public CtTravelNotes getTravelNotes() {
		return travelNotes;
	}
	public void setTravelNotes(CtTravelNotes travelNotes) {
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
	public int getDisSize() {
		return disSize;
	}
	public void setDisSize(int disSize) {
		this.disSize = disSize;
	}
	public List<CtDiscuss> getDisList() {
		return disList;
	}
	public void setDisList(List<CtDiscuss> disList) {
		this.disList = disList;
	}
}
