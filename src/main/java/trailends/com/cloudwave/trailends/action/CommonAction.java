package com.cloudwave.trailends.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cloudwave.fwapp.base.action.BaseAction;

/**
 * @description 通用业务处理
 * @author DolphinBoy
 * @date 2013年12月10日 下午2:24:02
 * TODO
 */

@Controller
@RequestMapping(value="/common")
public class CommonAction extends BaseAction {
	private static Logger logger = LoggerFactory.getLogger(CommonAction.class);
	
	
	@RequestMapping(method=RequestMethod.GET, value="/doc")
	@ResponseBody
	public String document() {
		
		logger.info("获取系统信息.");
		return "非法访问!";
	}
}
