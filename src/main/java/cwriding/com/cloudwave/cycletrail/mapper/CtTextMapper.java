package com.cloudwave.cycletrail.mapper;

import com.cloudwave.cycletrail.domain.CtText;
import com.cloudwave.fw.dao.Mapper;

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
