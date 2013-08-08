package com.cloudwave.fw.service;

import com.cloudwave.fw.dao.AbstractDao;
import com.cloudwave.fw.domain.AbstractEntity;



public abstract class AbstractService implements BaseService {
	private AbstractDao<AbstractEntity> baseDao;
	
	//public abstract void save();
	
	

	public AbstractEntity get() {
		
		return null;
	}
	
	
}
