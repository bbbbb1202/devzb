
package com.devzb.framework.utils;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;

import com.devzb.framework.common.bean.Protocol;

/**
 * web数据发送工具
 * 
 * @author zhangbin
 *
 */
public class WebDataUtil {
	/**
	 * 返回json字符串
	 * 
	 * @param response
	 * @param data
	 */
	public static void sendJsonData(HttpServletResponse response, Protocol protocol) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().print(JsonUtil.getEntity2Json(protocol));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回json字符串
	 * 
	 * @param response
	 * @param data
	 */
	public static void sendJsonData(HttpServletResponse response, String data) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().print(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回json字符串
	 * 
	 * @param response
	 * @param code
	 * @param message
	 */
	public static void sendJsonData(HttpServletResponse response, int code, String message) {
		Protocol protocol = new Protocol();
		protocol.setCode(code);
		protocol.setMsg(message);

		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json;charset=UTF-8");
		try {
			response.getWriter().print(JsonUtil.getEntity2Json(protocol));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 返回普通字符串
	 * 
	 * @param response
	 * @param data
	 */
	public static void sendTextData(HttpServletResponse response, String data) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
		try {
			response.getWriter().print(data);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 重定向页面
	 * 
	 * @param response
	 * @param url
	 */
	public static void sendRedirect(HttpServletResponse response, String url) {
		try {
			response.setStatus(HttpStatus.MOVED_PERMANENTLY.value());
			response.sendRedirect(url);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
