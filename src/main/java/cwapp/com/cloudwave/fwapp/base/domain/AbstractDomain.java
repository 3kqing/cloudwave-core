package com.cloudwave.fwapp.base.domain;

import java.util.Date;

import com.cloudwave.fwapp.module.domain.User;

public abstract class AbstractDomain extends AbstractEntity {
	private static final long serialVersionUID = 2312584095541134709L;

	protected String tag;
	protected Integer order;
	
	protected Date createTime; // 对象的创建时间
	protected User createBy; // 持久化对象的创建人
	protected Date lastUpdateTime; // 该对象最后更新时间
	protected User lastUpdateBy; // 该对象最后更新人
	protected Boolean enable; // 该对象的有效标识
	
	
	public String getTag() {
		return tag;
	}
	public void setTag(String tag) {
		this.tag = tag;
	}
	public Integer getOrder() {
		return order;
	}
	public void setOrder(Integer order) {
		this.order = order;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public User getCreateBy() {
		return createBy;
	}
	public void setCreateBy(User createBy) {
		this.createBy = createBy;
	}
	public Date getLastUpdateTime() {
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime) {
		this.lastUpdateTime = lastUpdateTime;
	}
	public User getLastUpdateBy() {
		return lastUpdateBy;
	}
	public void setLastUpdateBy(User lastUpdateBy) {
		this.lastUpdateBy = lastUpdateBy;
	}
	public Boolean getEnable() {
		return enable;
	}
	public void setEnable(Boolean enable) {
		this.enable = enable;
	}
}
