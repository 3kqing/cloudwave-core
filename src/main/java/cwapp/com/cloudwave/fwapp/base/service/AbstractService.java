package com.cloudwave.fwapp.base.service;

import com.cloudwave.fwapp.base.dao.AbstractDao;
import com.cloudwave.fwapp.base.domain.AbstractEntity;



public abstract class AbstractService implements Service {
	private AbstractDao<AbstractEntity> baseDao;
	
	//public abstract void save();
	
	

//	public AbstractEntity get(String id) {
//		
//		return this.baseDao.get(id);
//	}

	
}
