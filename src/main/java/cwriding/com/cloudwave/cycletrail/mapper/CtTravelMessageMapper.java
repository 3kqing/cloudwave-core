package com.cloudwave.cycletrail.mapper;

import java.util.List;

import com.cloudwave.cycletrail.domain.CtTravelMessage;
import com.cloudwave.fwapp.base.dao.Mapper;

public interface CtTravelMessageMapper extends Mapper {

	public CtTravelMessage get(String id);

	public void insert(CtTravelMessage tm);

	public List<CtTravelMessage> load(int count);
	
}
