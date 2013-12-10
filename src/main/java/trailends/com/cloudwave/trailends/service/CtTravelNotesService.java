package com.cloudwave.trailends.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.fwapp.base.service.BaseService;
import com.cloudwave.trailends.domain.CtTravelNotes;
import com.cloudwave.trailends.mapper.CtTravelNotesMapper;

@Service
public class CtTravelNotesService extends BaseService {

	
	@Resource
	private CtTravelNotesMapper ctTravelNotesMapper;

	public CtTravelNotes get(String id) {
		return this.ctTravelNotesMapper.get(id);
	}
	
	public void save(CtTravelNotes tn) {
		this.ctTravelNotesMapper.insert(tn);
	}
}
