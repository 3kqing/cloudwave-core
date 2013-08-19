package com.cloudwave.cycletrail.mapper;

import com.cloudwave.cycletrail.domain.CtPicture;
import com.cloudwave.fwapp.base.dao.Mapper;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-8-8 下午9:43:49
 * TODO
 */

public interface CtPictureMapper extends Mapper {

	public CtPicture get(String id);

	public void insert(CtPicture p);
	
	
	
}
