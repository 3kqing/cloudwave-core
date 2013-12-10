package com.cloudwave.trailends.mapper;

import com.cloudwave.fwapp.base.dao.Mapper;
import com.cloudwave.trailends.domain.CtText;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-8 下午9:43:49
 * TODO
 */

public interface CtTextMapper extends Mapper {

	public CtText get(String id);

	public void insert(CtText t);
	
	
	
}
