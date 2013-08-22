package com.cloudwave.cycletrail.mapper;

import com.cloudwave.cycletrail.domain.CtTravelNotes;
import com.cloudwave.fwapp.base.dao.Mapper;

public interface CtTravelNotesMapper extends Mapper {
	
	public CtTravelNotes get(String id);

	public void insert(CtTravelNotes tn);
}
