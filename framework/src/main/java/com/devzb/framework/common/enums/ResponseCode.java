
package com.devzb.framework.common.enums;

/**
 * 请求返回的code枚举
 * 
 * @author zhangbin
 *
 */
public enum ResponseCode {

	/**
	 * 请求成功
	 */
	SUCCESS(200000),
	/**
	 * 502错误（非法操作）
	 */
	BAD_GATEWAY(200502),
	/**
	 * 请求时系统发生内部错误
	 */
	FAIL(200444),
	/**
	 * 缺少参数
	 */
	LOST(400001),
	/**
	 * 未登录
	 */
	NO_LOGIN(200401);

	public Integer code;

	private ResponseCode(Integer code) {
		this.code = code;
	}
}
