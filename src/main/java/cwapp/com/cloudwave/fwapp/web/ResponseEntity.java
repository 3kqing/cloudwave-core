package com.cloudwave.fwapp.web;

import org.apache.commons.lang3.StringUtils;

import com.cloudwave.fwapp.base.entity.ResultEntity;


/**
 * User: DolphinBoy
 * Date: 13-7-11
 * Time: 下午11:19
 * Response返回实体封装
 */
public class ResponseEntity extends ResultEntity implements Response {

    /**
     * 默认返回码为: FAIL 失败
     */
    public ResponseEntity() {
        this.code = ResponseEntity.FAIL;
        this.data = "";
    }
    public ResponseEntity(String code) {
        this.code = code;
        this.data = "";
    }
    public ResponseEntity(String code, String info) {
        this.code = code;
        this.info = info;
        this.data = "";
    }

    public void setResponseMessage(String code, String info) {
        this.code = code;
        this.info = info;
        this.data = "";
    }

    public void setCode(String code) {
        this.code = code;
        
        if (SUCCESS.equals(code)) {
        	this.info = "操作成功!";
        } else if (WARN.equals(code)) {
        	this.info = "警告!";
        } else if (FAIL.equals(code)) {
        	this.info = "操作失败!";
        } else if (ERROR.equals(code)) {
        	this.info = "错误!";
        } else if (NONE.equals(code)) {
        	this.info = "";
        } else if (SAVE_SUCCESS.equals(code)) {
        	this.info = "保存成功!";
        } else if (SAVE_FAIL.equals(code)) {
        	this.info = "保存失败!";
        } else if (UPDATE_SUCCESS.equals(code)) {
        	this.info = "更新成功!";
        } else if (UPDATE_FAIL.equals(code)) {
        	this.info = "更新失败!";
        } else if (DELETE_SUCCESS.equals(code)) {
        	this.info = "删除成功!";
        } else if (DELETE_FAIL.equals(code)) {
        	this.info = "删除失败!";
        }
    }
    public void setCode(String code, String info) {
    	this.code = code;
    	this.info = info;
    }
    public void setData(Object data) {
        this.data = data;
        if (data != null) {
        	this.code = SUCCESS;
            this.info = "获取数据成功!";
        }
    }
    public void setData(Object data, String code) {
        this.data = data;
        this.code = code;
    }
	public ResponseEntity parseResult(ResultEntity r) {
		this.setCode(r.getCode());
		if (StringUtils.isNotEmpty(r.getInfo())) {
			this.setInfo(r.getInfo());
		}
		if (r.getData() != null) {
			this.setData(r.getData());
		}
		return this;
	}
}
