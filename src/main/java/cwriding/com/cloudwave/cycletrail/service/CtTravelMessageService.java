package com.cloudwave.cycletrail.service;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.cycletrail.domain.CtTripMessage;
import com.cloudwave.cycletrail.mapper.CtTravelMessageMapper;
import com.cloudwave.fwapp.base.service.AbstractService;

@Service
public class CtTravelMessageService extends AbstractService {

	@Resource
	private CtTravelMessageMapper ctTravelMessageMapper;

	public CtTripMessage get(String id) {
		return this.ctTravelMessageMapper.get(id);
	}
	
	public void save(CtTripMessage tm) {
		this.ctTravelMessageMapper.insert(tm);
	}

	public List<CtTripMessage> load(int count) {
		return this.ctTravelMessageMapper.load(count);
	}
	public List<CtTripMessage> load(int count, Date date) {
		return this.ctTravelMessageMapper.load(count, date);
	}
	
}
