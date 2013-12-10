package com.cloudwave.fwapp.base.dao;

import com.cloudwave.fwapp.base.domain.BaseEntity;

public abstract class BaseDao<T> implements Dao<T> {
	private static final long serialVersionUID = -8294558340860380832L;

	public abstract BaseEntity get(String id);
}
