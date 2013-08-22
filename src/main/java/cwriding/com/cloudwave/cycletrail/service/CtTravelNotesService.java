package com.cloudwave.cycletrail.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.cloudwave.cycletrail.domain.CtTravelNotes;
import com.cloudwave.cycletrail.mapper.CtTravelNotesMapper;
import com.cloudwave.fwapp.base.service.AbstractService;

@Service
public class CtTravelNotesService extends AbstractService {

	
	@Resource
	private CtTravelNotesMapper ctTravelNotesMapper;

	public CtTravelNotes get(String id) {
		return this.ctTravelNotesMapper.get(id);
	}
	
	public void save(CtTravelNotes tn) {
		this.ctTravelNotesMapper.insert(tn);
	}
}
