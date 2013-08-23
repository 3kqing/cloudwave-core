package com.cloudwave.fwapp.web;

/**
 * User: DolphinBoy
 * Date: 13-7-11
 * Time: 下午11:21
 * To change this template use File | Settings | File Templates.
 */
public interface Response {
	
	public static final String SUCCESS = "success";
	public static final String INFO = "info";
    public static final String WARN = "warn";
    public static final String FAIL = "fail";
    public static final String ERROR = "error";
    public static final String NONE = "none";
    
    
    public static final String SAVE_SUCCESS = "save_success";
    public static final String SAVE_FAIL = "save_fail";
    public static final String UPDATE_SUCCESS = "update_success";
    public static final String UPDATE_FAIL = "update_fail";
    public static final String DELETE_SUCCESS = "delete_success";
    public static final String DELETE_FAIL = "delete_fail";
    
}
