package com.cloudwave.trailends.mapper;

import java.util.List;
import java.util.Map;

import com.cloudwave.fwapp.base.dao.Mapper;
import com.cloudwave.trailends.domain.CtTripMessage;

public interface CtTripMessageMapper extends Mapper {

	public CtTripMessage get(long id);

	public void insert(CtTripMessage tm);

	public List<CtTripMessage> load(int count);

	public int countNewerById(Long lastid);

	public List<CtTripMessage> loadNewer(Map<String, Long> params);

	public List<CtTripMessage> loadOlder(Map<String, Long> params);

	public List<CtTripMessage> loadNewest(Map<String, Integer> params);


}
