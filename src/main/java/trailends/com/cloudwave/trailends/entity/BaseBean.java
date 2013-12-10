package com.cloudwave.trailends.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-10-13 下午2:13:49
 * TODO
 */

public class BaseBean {
	
	protected String token;

	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}
	
	public static List<Long> convertToIdList(String idstr, String regex) {
		List<Long> idList = new ArrayList<Long>();
		try {
			String[] idArr = idstr.split(idstr);
			for (String s : idArr) {
				idList.add(Long.parseLong(s));
			}
		} catch (Exception e) {
			return idList;
		}
		return idList;
	}
}
