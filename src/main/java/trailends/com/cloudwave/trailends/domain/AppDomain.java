package com.cloudwave.trailends.domain;

import java.util.Date;

import com.cloudwave.fwapp.base.domain.BaseEntity;
import com.cloudwave.fwapp.module.domain.User;

/**
 * @description 业务实体类, 主要定义通用的业务属性
 * @author wangwenlong
 * 2013年12月6日 上午11:17:39
 * TODO
 */

public class AppDomain extends BaseEntity {
	private static final long serialVersionUID = -7313156613433703333L;
	
	protected Date createTime;
	protected User createBy;
	protected Date sendTime;
	protected Integer order;
	protected Integer offlineId;  //离线数据的ID
	
}
