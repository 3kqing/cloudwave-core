package com.cloudwave.fw.dao;

import com.cloudwave.fw.domain.AbstractEntity;

public abstract class AbstractDao<T> implements Dao<T> {

	public abstract AbstractEntity get(String id);
}
