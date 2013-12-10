package com.cloudwave.trailends.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.fwapp.base.service.BaseService;
import com.cloudwave.trailends.domain.CtTripMessage;
import com.cloudwave.trailends.mapper.CtTripMessageMapper;

@Service
public class CtTripMessageService extends BaseService {

	@Resource
	private CtTripMessageMapper ctTravelMessageMapper;

	public CtTripMessage get(long id) {
		return this.ctTravelMessageMapper.get(id);
	}
	
	public void save(CtTripMessage tm) {
		this.ctTravelMessageMapper.insert(tm);
	}

	public List<CtTripMessage> loadNewer(long num, Long id) {
		int sum = this.ctTravelMessageMapper.countNewerById(id);
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);
		params.put("num",  num);
		if (sum > num) {
			num = sum;
		}
		return this.ctTravelMessageMapper.loadNewer(params);
	}
	public List<CtTripMessage> loadOrder(long num, Long id) {
		Map<String, Long> params = new HashMap<String, Long>();
		params.put("id", id);
		params.put("num",  num);
		return this.ctTravelMessageMapper.loadOlder(params);
	}

	public List<CtTripMessage> loadNewest(int num) {
		Map<String, Integer> params = new HashMap<String, Integer>();
		params.put("num", num);
		return this.ctTravelMessageMapper.loadNewest(params);
	}
	
}
