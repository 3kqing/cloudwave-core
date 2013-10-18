package com.cloudwave.cycletrail.service;

import java.util.List;

import javax.annotation.Resource;

import com.cloudwave.cycletrail.domain.CtAtUser;
import com.cloudwave.cycletrail.mapper.CtAtUserMapper;
import com.cloudwave.fwapp.base.service.AbstractService;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-10-13 下午5:52:26
 * TODO
 */

public class TeAtUserService extends AbstractService {
	
	@Resource
	private CtAtUserMapper ctAtUserMapper;
	
	public void saveAll(List<CtAtUser> atuList) {
		this.ctAtUserMapper.insertAll(atuList);
	}

}
