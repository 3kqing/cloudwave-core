package com.cloudwave.fwcore.entity;

import com.alibaba.fastjson.JSON;


/**
 * 轻量级响应结果封装:返回JSON字符串
 * @author DolphinBoy
 * 2013-11-8
 */
public class ResultTmpl {
	private static final String TEMPLATE = "{\"result\":\"_result\",\"msg\":\"_msg\"}";
	private static final String TEMPLATE_CODE = "{\"result\":\"_result\",\"code\":\"_code\",\"msg\":\"_msg\"}";
	private static final String TEMPLATE_DATA = "{\"result\":\"_result\",\"code\":\"_code\",\"msg\":\"_msg\",\"data\":\"_data\"}";
	
	/**成功*/
	public static final String SUCCESS = "success";
	/**警告*/
	public static final String WARN = "warn";
	/**失败*/
	public static final String FAILURE = "failure";
	
	/**
	 * 返回消息。
	 * @param msg
	 * @param code
	 * @return
	 */
	public static String message(String result, String msg){
		return TEMPLATE.replace("_result", result).replace("_msg", msg);
	}
	
	/**
	 * 返回消息。
	 * @param msg
	 * @param code
	 * @return
	 */
	public static String message(String result, String code, String msg){
		return TEMPLATE_CODE.replace("_result", result).replace("_code", code).replace("_msg", msg);
	}
	
	
	/**
	 * 返回带结果的数据。
	 * @param msg
	 * @param code
	 * @param data
	 * @return
	 */
	public static String message(String msg,int code,String data){
		return TEMPLATE_DATA.replace("_msg", msg).replace("_code", code+"").replace("_data", data);
	}
	
	
	/**
	 * 返回成功。
	 * @param data
	 * @return
	 */
	public static String success(){
		return TEMPLATE.replace("_result", SUCCESS).replace("_msg", "成功!");
	}
	
	/**
	 * 返回成功的数据。
	 * @param data
	 * @return
	 */
	public static String success(String data){
		return TEMPLATE_DATA.replace("_result", SUCCESS).replace("_msg", "成功!").replace("_data", data);
	}
	/**
	 * 返回成功的数据。
	 * @param data
	 * @return
	 */
	public static String success(String msg, Object data){
		return TEMPLATE_DATA.replace("_result", SUCCESS).replace("_msg", msg).replace("_data", JSON.toJSONString(data));
	}
	/**
	 * 返回成功的数据。
	 * @param data
	 * @return
	 */
	public static String success(Object data){
		return TEMPLATE_DATA.replace("_result", SUCCESS).replace("_msg", "成功!").replace("_data", JSON.toJSONString(data));
	}
	
	
	/**
	 * 返回成功。
	 * @param data
	 * @return
	 */
	public static String warn(String code, String msg){
		return TEMPLATE.replace("_result", WARN).replace("_code", code).replace("_msg", msg);
	}
	
	
	/**
	 * 通用失败提示。
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String failure(){
		return TEMPLATE_CODE.replace("_result", FAILURE).replace("_msg", "失败!");
	}
	
	/**
	 * 通用失败提示。
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String failure(String msg){
		return TEMPLATE_CODE.replace("_result", FAILURE).replace("_msg", msg);
	}
	
	/**
	 * 通用失败提示。
	 * @param code
	 * @param msg
	 * @return
	 */
	public static String failure(String code, String msg){
		return TEMPLATE_CODE.replace("_result", FAILURE).replace("_code", code).replace("_msg", msg);
	}
	
	/**
	 * 通用失败提示。
	 * @param code
	 * @param msg
	 * @param data JSON字符串
	 * @return
	 */
	public static String failure(String code, String msg, String data){
		return TEMPLATE_CODE.replace("_result", FAILURE).replace("_code", code).replace("_msg", msg).replace("_data", data);
	}
	
	/**
	 * 通用失败提示。
	 * @param msg
	 * @return
	 */
	public static String failure(String code, String msg, Object data){
		return TEMPLATE_CODE.replace("_result", FAILURE).replace("_code", code).replace("_msg", msg).replace("_data", JSON.toJSONString(data));
	}
}
