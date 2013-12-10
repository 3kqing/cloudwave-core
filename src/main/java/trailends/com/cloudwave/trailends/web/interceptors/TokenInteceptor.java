package com.cloudwave.trailends.web.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @description Token拦截器
 * @author wangwenlong
 * 2013年12月6日 上午11:51:04
 * TODO
 */

public class TokenInteceptor implements HandlerInterceptor {
	private final static Logger logger = LoggerFactory.getLogger(TokenInteceptor.class); 
	
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
