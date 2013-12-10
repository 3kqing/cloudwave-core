package com.cloudwave.cycletrail.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.cycletrail.domain.CtLocation;
import com.cloudwave.cycletrail.mapper.CtLocationMapper;
import com.cloudwave.fwapp.base.service.AbstractService;

@Service
public class TeLocationService extends AbstractService {

	@Resource
	private CtLocationMapper ctLocationMapper;
	
	public void save(CtLocation location) {
		this.ctLocationMapper.insert(location);
	}

}
