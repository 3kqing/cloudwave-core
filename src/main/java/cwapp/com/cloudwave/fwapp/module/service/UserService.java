package com.cloudwave.fwapp.module.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.fwapp.base.service.AbstractService;
import com.cloudwave.fwapp.module.domain.User;
import com.cloudwave.fwapp.module.mapper.UserMapper;

@Service
public class UserService extends AbstractService {

	@Resource
	private UserMapper userMapper;

	public User get(String id) {
		return this.userMapper.get(id);
	}
	
	public void save(User u) {
		this.userMapper.insert(u);
	}

	public User getByName(String username) {
		// TODO Auto-generated method stub
		return null;
	}

	public User getByAccountOrEmail(String accountOrEmail) {
		return this.userMapper.getByAccountOrEmail(accountOrEmail);
	}

	public boolean checkEmail(String email) {
		int sum = this.userMapper.findByEmail(email);
		if (sum > 0) {
			return true;
		} else {
			return false;
		}
	}

	public boolean checkUsername(String username) {
		int sum = this.userMapper.findByUsername(username);
		if (sum > 0) {
			return true;
		} else {
			return false;
		}
	}
}
