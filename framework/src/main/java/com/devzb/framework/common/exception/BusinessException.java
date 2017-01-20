
package com.devzb.framework.common.exception;

/**
 * 业务异常类
 * 
 * @author zhangbin
 *
 */
public class BusinessException extends BaseException {
	private static final long serialVersionUID = 5129043727626083557L;

	public BusinessException(Integer code) {
		super(code);
	}

	public BusinessException(Integer code, String message) {
		super(code, message);
	}
}
