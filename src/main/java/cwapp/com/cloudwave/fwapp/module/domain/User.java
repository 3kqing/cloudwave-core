package com.cloudwave.fwapp.module.domain;

import com.cloudwave.fwapp.base.domain.AbstractDomain;


/**
 * User: DolphinBoy
 * Date: 13-7-6
 * Time: 下午9:56
 * To change this template use File | Settings | File Templates.
 */
public class User extends AbstractDomain {
	private static final long serialVersionUID = 6540471194357488833L;
	
	private String name;
	private String password;
	private String email;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
