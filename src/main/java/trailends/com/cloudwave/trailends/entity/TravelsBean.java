package com.cloudwave.trailends.entity;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import com.cloudwave.cycletrail.domain.CtLocation;
import com.cloudwave.cycletrail.domain.CtTravels;
import com.cloudwave.fwapp.base.entity.ResultEntity;
import com.cloudwave.fwapp.module.domain.User;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-10-17 下午10:40:06
 * TODO
 */

public class TravelsBean extends BaseBean {
	
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date beginDate;
	@DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
	private Date endDate;
	
	private String beginLocation;
	private String endLocation;
	
	private Long userId;
	
	private Long partner;
	
	
	public ResultEntity toTravels() {
		ResultEntity re = new ResultEntity(ResultEntity.FAIL);
		CtTravels t = new CtTravels();
//		t.setText(this.getText());
		
		
		return re;
	}
}
