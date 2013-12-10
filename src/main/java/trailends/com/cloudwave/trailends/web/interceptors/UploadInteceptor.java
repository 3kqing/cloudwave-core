package com.cloudwave.trailends.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description 文件上传拦截器
 * @author wangwenlong
 * 2013年12月6日 下午4:21:00
 * TODO
 */

public class UploadInteceptor implements HandlerInterceptor {
	private final static Logger logger = LoggerFactory.getLogger(UploadInteceptor.class); 
	
	@Override
	public boolean preHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler) throws Exception {
		logger.debug("TokenInteceptor --> preHandle");
		return false;
	}

	@Override
	public void postHandle(HttpServletRequest request,
			HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		logger.debug("TokenInteceptor --> postHandle");
		
	}

	@Override
	public void afterCompletion(HttpServletRequest request,
			HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		logger.debug("TokenInteceptor --> afterCompletion");
		
	}

}
