package com.cloudwave.fwcore.enums;

/**
 * @description 结果类型枚举类
 * @author DolphinBoy
 * 2013年11月6日 下午3:55:40
 * TODO
 */

public enum ResultType {
	SUCCESS(1, "success", "成功!"),
	FAILURE(0, "failure", "失败!"),
	WARN(2, "warn", "警告!");
	
	private int id;
	private String code;
	private String name;
	
	
	private ResultType(int id, String code, String name) {
		this.id = id;
		this.code = code;
		this.name = name;
	}
	
	public static ResultType getById(int v) {
		ResultType gender = null;
		ResultType[] list = ResultType.values();

		for (ResultType g : list) {
			if (g.id == v) {
				gender = g;
			}
		}
		return gender;
	}
	public static ResultType getByName(String name) {
		return ResultType.valueOf(name);
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
}
