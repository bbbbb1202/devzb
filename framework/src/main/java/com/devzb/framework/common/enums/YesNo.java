
package com.devzb.framework.common.enums;

/**
 * 是否枚举
 * 
 * @author zhangbin
 *
 */
public enum YesNo {

	/**
	 * 是
	 */
	YES("y"),
	/**
	 * 否
	 */
	NO("n");

	public String value;

	private YesNo(String value) {
		this.value = value;
	}
}
