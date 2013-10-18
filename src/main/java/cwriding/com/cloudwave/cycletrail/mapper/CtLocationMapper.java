package com.cloudwave.cycletrail.mapper;

import com.cloudwave.cycletrail.domain.CtLocation;
import com.cloudwave.fwapp.base.dao.Mapper;

public interface CtLocationMapper extends Mapper {

	public void insert(CtLocation location);

}
