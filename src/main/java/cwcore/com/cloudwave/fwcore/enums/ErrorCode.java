package com.cloudwave.fwcore.enums;

/**
 * @description 
 * @author DolphinBoy
 * 2013年11月8日 上午10:39:31
 * TODO
 */

public enum ErrorCode {
	SUCCESS(1, "成功!"),
	FAILURE(0, "失败!");
	
	private int code;
	private String msg;
	
	private ErrorCode(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}


	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
