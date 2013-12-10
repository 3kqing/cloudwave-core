package com.cloudwave.fwapp.base.service;

import com.cloudwave.fwapp.base.dao.BaseDao;
import com.cloudwave.fwapp.base.domain.BaseEntity;



public abstract class BaseService implements Service {
	private BaseDao<BaseEntity> baseDao;
	
	//public abstract void save();
	
	

//	public AbstractEntity get(String id) {
//		
//		return this.baseDao.get(id);
//	}

	
}
