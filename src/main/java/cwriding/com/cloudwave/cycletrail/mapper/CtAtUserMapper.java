package com.cloudwave.cycletrail.mapper;

import java.util.List;

import com.cloudwave.cycletrail.domain.CtAtUser;
import com.cloudwave.fwapp.base.dao.Mapper;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-10-13 下午5:52:51
 * TODO
 */

public interface CtAtUserMapper extends Mapper {

	public void insertAll(List<CtAtUser> atuList);

}
