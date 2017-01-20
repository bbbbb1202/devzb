
package com.devzb.framework.common.exception;

import org.apache.commons.lang.StringUtils;

/**
 * 基础异常类，其他异常需继承
 * 
 * @author zhangbin
 *
 */
public class BaseException extends RuntimeException {
	private static final long	serialVersionUID	= 5258394054543228738L;
	private static final String	DEFAULT				= "系统内部异常";

	private Integer				code;
	private String				message;

	public BaseException(Integer code) {
		this.code = code;
	}

	public BaseException(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}

	@Override
	public String getMessage() {
		return StringUtils.isBlank(message) ? DEFAULT : message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
}
