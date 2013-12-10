package com.cloudwave.cycletrail.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.cycletrail.domain.CtTravels;
import com.cloudwave.cycletrail.mapper.CtTravelsMapper;
import com.cloudwave.fwapp.base.service.AbstractService;

@Service
public class TeTravelsService extends AbstractService {

	
	@Resource
	private CtTravelsMapper ctTravelsMapper;

	public CtTravels get(String id) {
		return this.ctTravelsMapper.get(id);
	}
	
	public void save(CtTravels tn) {
		this.ctTravelsMapper.insert(tn);
	}
}
