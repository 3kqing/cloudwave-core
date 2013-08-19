package com.cloudwave.fwapp.base.domain;

public abstract class AbstractEntity implements Entity {
	protected String id;  // 持久化Id,持久化对象的唯一标示

	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
}
