package com.cloudwave.trailends.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.fwapp.base.service.BaseService;
import com.cloudwave.trailends.domain.CtText;
import com.cloudwave.trailends.mapper.CtTextMapper;

@Service
public class CtTextService extends BaseService {

	@Resource
	private CtTextMapper ctTextMapper;

	public CtText get(String id) {
		return this.ctTextMapper.get(id);
	}
	
	public void save(CtText t) {
		this.ctTextMapper.insert(t);
	}
}
