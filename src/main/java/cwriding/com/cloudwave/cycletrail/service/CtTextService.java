package com.cloudwave.cycletrail.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.cycletrail.domain.CtText;
import com.cloudwave.cycletrail.mapper.CtTextMapper;
import com.cloudwave.fwapp.base.service.AbstractService;

@Service
public class CtTextService extends AbstractService {

	@Resource
	private CtTextMapper ctTextMapper;

	public CtText get(String id) {
		return this.ctTextMapper.get(id);
	}
	
	public void save(CtText t) {
		this.ctTextMapper.insert(t);
	}
}
