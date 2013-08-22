package com.cloudwave.fwapp.web;


/**
 * User: DolphinBoy
 * Date: 13-7-11
 * Time: 下午11:19
 * Response返回实体封装
 */
public class ResponseEntity implements Response {
    private String code;
    private String info;
    private Object data;

    /**
     * 默认返回码为: FAIL 失败
     */
    public ResponseEntity() {
        this.code = ResponseEntity.FAIL;
    }
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
    public void setData(Object data, String code) {
        this.data = data;
        this.code = code;
    }
}
