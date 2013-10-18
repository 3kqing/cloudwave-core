package com.cloudwave.cycletrail.domain;

import com.cloudwave.fwapp.base.domain.AbstractDomain;

/**
 * @description 
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-10-13 下午5:36:18
 * TODO
 */

public class CtAtUser extends AbstractDomain {
	private static final long serialVersionUID = 840845730095127784L;
	public static final boolean HAS_READ = true;
	public static final boolean HASNOT_READ = false;
	private Long id;
	private Long objId;
	private Long userId;
	
	private boolean hasRead = false;

	
	public CtAtUser() {
	}

	public CtAtUser(Long objId, Long userId) {
		this.objId = objId;
		this.userId = userId;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getObjId() {
		return objId;
	}

	public void setObjId(Long objId) {
		this.objId = objId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public boolean isHasRead() {
		return hasRead;
	}

	public void setHasRead(boolean hasRead) {
		this.hasRead = hasRead;
	}
	
}
