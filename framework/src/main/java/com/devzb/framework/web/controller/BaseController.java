package com.devzb.framework.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.devzb.framework.utils.WebDataUtil;


/**
 * 基础Controller，公共的方法在这里处理
 * 
 * @author zhangbin
 *
 */
public class BaseController {

	protected Logger logger = LoggerFactory.getLogger(getClass());

	/**
	 * 成功页面
	 */
	protected static final String	SUCCESS	= "framework/success";
	/**
	 * 错误页面
	 */
	protected static final String	ERROR	= "framework/error";
	/**
	 * 返回页面
	 */
	protected static final String	BACK	= "framework/back";

	/**
	 * 获得request
	 * 
	 * @return
	 */
	protected HttpServletRequest getRequest() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
	}

	/**
	 * 获得response
	 * 
	 * @return
	 */
	protected HttpServletResponse getResponse() {
		return ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
	}

	/**
	 * 返回json字符串
	 * 
	 * @param response
	 * @param data
	 */
	protected void sendJsonData(HttpServletResponse response, String data) {
		WebDataUtil.sendJsonData(response, data);
	}

	/**
	 * 返回普通字符串
	 * 
	 * @param response
	 * @param data
	 */
	protected void sendTextData(HttpServletResponse response, String data) {
		WebDataUtil.sendTextData(response, data);
	}

	/**
	 * 重定向页面
	 * 
	 * @param response
	 * @param url
	 */
	protected void sendRedirect(HttpServletResponse response, String url) {
		WebDataUtil.sendRedirect(response, url);
	}
}
