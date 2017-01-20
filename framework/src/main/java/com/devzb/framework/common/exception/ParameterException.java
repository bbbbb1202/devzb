
package com.devzb.framework.common.exception;

/**
 * 参数异常类
 * 
 * @author zhangbin
 *
 */
public class ParameterException extends BaseException {

	private static final long serialVersionUID = -5679286376502210180L;

	public ParameterException(Integer code) {
		super(code);
	}

	public ParameterException(Integer code, String message) {
		super(code, message);
	}
}
