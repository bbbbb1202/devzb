
package com.devzb.framework.enums;

/**
 * 是否
 * 
 * @author zhangb
 *
 */
public enum YesNo {

	YES("y"), // 是
	NO("n"); // 否

	public String value;

	private YesNo(String value) {
		this.value = value;
	}
}
