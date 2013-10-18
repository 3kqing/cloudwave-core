package com.cloudwave.trailends.entity;

import com.cloudwave.cycletrail.domain.CtLocation;
import com.cloudwave.cycletrail.domain.CtTripMessage;
import com.cloudwave.fwapp.base.entity.ResultEntity;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-10-13 下午2:13:28
 * TODO
 */

public class TripMessageBean extends BaseBean {

	private String picture;
	private String text;
	private String at;
	private String weibo;
	private String qqweibo;
	private String address;
	private Float direction;
	private Double latitude;
	private Double longitude;
	
	
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getAt() {
		return at;
	}
	public void setAt(String at) {
		this.at = at;
	}
	public String getWeibo() {
		return weibo;
	}
	public void setWeibo(String weibo) {
		this.weibo = weibo;
	}
	public String getQqweibo() {
		return qqweibo;
	}
	public void setQqweibo(String qqweibo) {
		this.qqweibo = qqweibo;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Float getDirection() {
		return direction;
	}
	public void setDirection(Float direction) {
		this.direction = direction;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	
	public ResultEntity toTripMessage() {
		ResultEntity re = new ResultEntity(ResultEntity.FAIL);
		CtTripMessage tm = new CtTripMessage();
		tm.setText(this.getText());
		tm.setAddress(this.getAddress());
		
		CtLocation location = new CtLocation();
		location.setDirection(this.getDirection());
		location.setLatitude(this.getLatitude());
		location.setLongitude(this.getLongitude());
		location.setAddress(tm.getAddress());
		tm.setLocation(location);
		return re;
	}
}
