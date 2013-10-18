package com.cloudwave.fwapp.base.entity;

/**
 * @description 结果
 * @author DolphinBoy
 * @email dolphinboyo@gmail.com
 * @date 2013-10-13 下午2:27:33
 * TODO
 */

public class ResultEntity implements Result {
	protected String code;
	protected String info;
	protected Object data;
	
	
	public ResultEntity() {
	}

	public ResultEntity(String code) {
		this.code = code;
	}
	
	public ResultEntity(String code, String info) {
		this.code = code;
		this.info = info;
	}

	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
}
