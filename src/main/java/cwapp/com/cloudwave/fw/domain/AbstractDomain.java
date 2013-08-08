package com.cloudwave.fw.domain;

import java.util.Date;

import com.cloudwave.fw.app.domain.User;

public abstract class AbstractDomain extends AbstractEntity {
	protected Date createTime; // 对象的创建时间
	protected User createBy; // 持久化对象的创建人
	protected Date lastUpdateTime; // 该对象最后更新时间
	protected User lastUpdateBy; // 该对象最后更新人
	protected Boolean enable; // 该对象的有效标识
	
	
	
}
