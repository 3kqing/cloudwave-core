package com.cloudwave.fwapp.base.domain;

public abstract class AbstractEntity implements Entity {
	protected Long id;  // 持久化Id,持久化对象的唯一标示

	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
}
