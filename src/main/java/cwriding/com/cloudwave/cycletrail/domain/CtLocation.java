package com.cloudwave.cycletrail.domain;

import java.util.Date;

import com.cloudwave.fwapp.base.domain.AbstractDomain;

public class CtLocation extends AbstractDomain {
	private static final long serialVersionUID = -3145688189728201157L;
	
	private Double longitude;  //经度
	private Double latitude;  //纬度
	private Double altitude;  //海拔
	private Date time;
	
	private String country;  //国家
	private String province;  //省,州
	private String city;  //城市
	private String town;  //城镇,市镇
	private String street;  //街道
	
	private String substance;  //参照物
	private String amend;  //修正
	
	public Double getLongitude() {
		return longitude;
	}
	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}
	public Double getLatitude() {
		return latitude;
	}
	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}
	public Double getAltitude() {
		return altitude;
	}
	public void setAltitude(Double altitude) {
		this.altitude = altitude;
	}
	public Date getTime() {
		return time;
	}
	public void setTime(Date time) {
		this.time = time;
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
