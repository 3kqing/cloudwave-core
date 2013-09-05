package com.cloudwave.cycletrail.mapper;

import java.util.Date;
import java.util.List;

import com.cloudwave.cycletrail.domain.CtTripMessage;
import com.cloudwave.fwapp.base.dao.Mapper;

public interface CtTravelMessageMapper extends Mapper {

	public CtTripMessage get(String id);

	public void insert(CtTripMessage tm);

	public List<CtTripMessage> load(int count);

	public List<CtTripMessage> load(int count, Date date);
	
}
