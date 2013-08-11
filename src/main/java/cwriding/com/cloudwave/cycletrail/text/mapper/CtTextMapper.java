package com.cloudwave.cycletrail.text.mapper;

import org.springframework.stereotype.Repository;

import com.cloudwave.cycletrail.text.domain.CtText;
import com.cloudwave.fw.dao.Mapper;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-8 下午9:43:49
 * TODO
 */

public interface CtTextMapper extends Mapper {

	public CtText get();
	
	
}
