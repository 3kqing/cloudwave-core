package com.cloudwave.fw.action.base;


/**
 * User: DolphinBoy
 * Date: 13-7-11
 * Time: 下午11:19
 * Response返回实体封装
 */
public class ResponseEntity implements Response {
    public static final String SUCCESS = "success";
    public static final String WARN = "warn";
    public static final String FAIL = "fail";
    public static final String ERROR = "error";
    public static final String NONE = "none";
    
    public static final String SAVE_SUCCESS = "save_success";
    public static final String SAVE_FAIL = "save_fail";
    public static final String UPDATE_SUCCESS = "update_success";
    public static final String UPDATE_FAIL = "update_fail";
    public static final String DELETE_SUCCESS = "delete_success";
    
    private String code;
    private String info;
    private Object data;


    public ResponseEntity(String code) {
        this.code = code;
    }
    public ResponseEntity(String code, String info) {
        this.code = code;
        this.info = info;
    }

    public void setResponseMessage(String code, String info) {
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
