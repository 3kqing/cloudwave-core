package com.cloudwave.fwapp.module.mapper;

import java.util.List;

import com.cloudwave.fwapp.base.dao.Mapper;
import com.cloudwave.fwapp.module.domain.User;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-8 下午9:43:49
 * TODO
 */

public interface UserMapper extends Mapper {

	public User get(String id);

	public void insert(User u);

	/**
	 * 根据邮箱查询用户
	 * @author wangwl
	 * @date 2013-8-22
	 * @param email
	 * @return
	 */
	public int findByEmail(String email);
	
	
	
}
