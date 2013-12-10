package com.cloudwave.trailends.domain;

import java.util.Date;

import com.cloudwave.fwapp.module.domain.FileEntity;
import com.cloudwave.fwapp.module.domain.User;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-18 下午10:28:23
 * TODO
 */

public class CtPicture extends AppDomain {
	private static final long serialVersionUID = -8026347735140976617L;
	
	private FileEntity file;
	
	private String title;
	private String desc;
	private String path;
	
	private Date sendTime;
	
	private CtTravelNotes travelNotes;
	private CtLocation location;
	private User user;
	
	private String timeAgo;

	
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
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
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
	
}
