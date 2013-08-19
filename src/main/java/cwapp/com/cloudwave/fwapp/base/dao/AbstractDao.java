package com.cloudwave.fwapp.base.dao;

import com.cloudwave.fwapp.base.domain.AbstractEntity;

public abstract class AbstractDao<T> implements Dao<T> {

	public abstract AbstractEntity get(String id);
}
