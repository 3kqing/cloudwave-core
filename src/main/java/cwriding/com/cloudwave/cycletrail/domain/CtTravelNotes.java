package com.cloudwave.cycletrail.domain;

import java.util.Date;
import java.util.List;

import com.cloudwave.fwapp.base.domain.AbstractDomain;
import com.cloudwave.fwapp.module.domain.User;

public class CtTravelNotes extends AbstractDomain {
	private static final long serialVersionUID = 7185064619044200621L;
	
	private Date beginDate;
	private Date endDate;
	
	private CtLocation beginLocation;
	private CtLocation endLocation;
	
	private User user;
	
	List<CtPicture> pictureList;
	List<CtText> textList;
	List<User> partner;
	
	
	public Date getBeginDate() {
		return beginDate;
	}
	public void setBeginDate(Date beginDate) {
		this.beginDate = beginDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public CtLocation getBeginLocation() {
		return beginLocation;
	}
	public void setBeginLocation(CtLocation beginLocation) {
		this.beginLocation = beginLocation;
	}
	public CtLocation getEndLocation() {
		return endLocation;
	}
	public void setEndLocation(CtLocation endLocation) {
		this.endLocation = endLocation;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<CtPicture> getPictureList() {
		return pictureList;
	}
	public void setPictureList(List<CtPicture> pictureList) {
		this.pictureList = pictureList;
	}
	public List<CtText> getTextList() {
		return textList;
	}
	public void setTextList(List<CtText> textList) {
		this.textList = textList;
	}
	public List<User> getPartner() {
		return partner;
	}
	public void setPartner(List<User> partner) {
		this.partner = partner;
	}
	
}
