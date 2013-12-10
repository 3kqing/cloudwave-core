package com.cloudwave.trailends.mapper;

import com.cloudwave.fwapp.base.dao.Mapper;
import com.cloudwave.trailends.domain.CtTravelNotes;

public interface CtTravelNotesMapper extends Mapper {
	
	public CtTravelNotes get(String id);

	public void insert(CtTravelNotes tn);
}
