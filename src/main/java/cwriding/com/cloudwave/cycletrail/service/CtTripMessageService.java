package com.cloudwave.cycletrail.service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.cycletrail.domain.CtTripMessage;
import com.cloudwave.cycletrail.mapper.CtTripMessageMapper;
import com.cloudwave.cycletrail.utils.StaticsVariable;
import com.cloudwave.fwapp.base.service.AbstractService;

@Service
public class CtTripMessageService extends AbstractService {

	@Resource
	private CtTripMessageMapper ctTravelMessageMapper;

	public CtTripMessage get(String id) {
		return this.ctTravelMessageMapper.get(id);
	}
	
	public void save(CtTripMessage tm) {
		this.ctTravelMessageMapper.insert(tm);
	}

	public List<CtTripMessage> loadNewer(long num, Long tmId) {
		long sum = this.ctTravelMessageMapper.countNewerById(tmId);
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("tmid", tmId);
		if (sum > num) {
			num += StaticsVariable.TM_COUNT_ADD;
			params.put("num",  num);
			return this.ctTravelMessageMapper.loadNewer(params);
		} else {
			params.put("num", num);
			return this.ctTravelMessageMapper.loadNewer(params);
		}
	}
	public List<CtTripMessage> loadOrder(long num, Long tmId) {
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("tmid", tmId);
		params.put("num",  num);
		return this.ctTravelMessageMapper.loadOlder(params);
	}
	
}
