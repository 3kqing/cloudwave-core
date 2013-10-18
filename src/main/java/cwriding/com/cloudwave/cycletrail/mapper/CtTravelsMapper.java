package com.cloudwave.cycletrail.mapper;

import com.cloudwave.cycletrail.domain.CtTravels;
import com.cloudwave.fwapp.base.dao.Mapper;

public interface CtTravelsMapper extends Mapper {
	
	public CtTravels get(String id);

	public void insert(CtTravels tn);
}
