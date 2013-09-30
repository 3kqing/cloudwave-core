package com.cloudwave.fwapp.module.domain;

import org.apache.commons.lang.StringUtils;

import com.cloudwave.cycletrail.utils.StaticsVariable;
import com.cloudwave.fwapp.base.domain.AbstractEntity;

/**
 * User: DolphinBoy
 * Date: 13-7-6
 * Time: 下午9:56
 * To change this template use File | Settings | File Templates.
 */
public class User extends AbstractEntity {
	private static final long serialVersionUID = 6540471194357488833L;
	
	private String username;
	private String nickname;
	private String password;
	private String email;
	private String avatar;
	
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
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
	public String getAvatar() {
		if (StringUtils.isNotEmpty(avatar)) {
			return StaticsVariable.STATIC_IMAGES_PREFIX + avatar;
		} else {
			return StaticsVariable.STATIC_IMAGES_PREFIX + StaticsVariable.DEFAULT_USER_AVATAR;
		}
		
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
}
