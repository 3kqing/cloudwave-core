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

	/**
	 * 根据用户名和邮箱查询用户
	 * 这里在业务上来讲不能返回多条数据，但考虑到尽量少的抛出异常此处是否要用集合来接受数据呢？
	 * @param accountOrEmail
	 * @return
	 */
	public User getByAccountOrEmail(String accountOrEmail);
	
	
	
}
