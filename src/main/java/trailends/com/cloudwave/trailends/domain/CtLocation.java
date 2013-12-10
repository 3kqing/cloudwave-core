package com.cloudwave.trailends.domain;

import java.util.Date;

public class CtLocation extends AppDomain {
	private static final long serialVersionUID = -3145688189728201157L;
	
	private Float accuracy;  //定位精度
	private Float direction;  //定位时的方向角度
	private Double latitude;  //纬度
	private Double longitude;  //经度
	private Float radius;  //定位精度半径，单位是米
	private Float speed;  //速度
	private Date time;  //时间
	
	private Integer satellitesNum; //定位时卫星的数目
	
	private String country;  //国家
	private String province;  //省,州
	private String district;  //区县
	private String city;  //城市
	private String town;  //城镇,市镇
	private String street;  //街道
	
	private String address;  //全部城市地址信息
	
	private String substance;  //参照物
	private String amend;  //修正
	
	
	public Float getAccuracy() {
		return accuracy;
	}
	public void setAccuracy(Float accuracy) {
		this.accuracy = accuracy;
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
	public Float getRadius() {
		return radius;
	}
	public void setRadius(Float radius) {
		this.radius = radius;
	}
	public Float getSpeed() {
		return speed;
	}
	public void setSpeed(Float speed) {
		this.speed = speed;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
	}
	public Integer getSatellitesNum() {
		return satellitesNum;
	}
	public void setSatellitesNum(Integer satellitesNum) {
		this.satellitesNum = satellitesNum;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getDistrict() {
		return district;
	}
	public void setDistrict(String district) {
		this.district = district;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getTown() {
		return town;
	}
	public void setTown(String town) {
		this.town = town;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getSubstance() {
		return substance;
	}
	public void setSubstance(String substance) {
		this.substance = substance;
	}
	public String getAmend() {
		return amend;
	}
	public void setAmend(String amend) {
		this.amend = amend;
	}
}
