
package com.devzb.framework.common.enums;

/**
 * 页码数量枚举
 * 
 * @author zhangbin
 *
 */
public enum PageSize {

	/**
	 * 8
	 */
	SMALL(8),

	/**
	 * 15
	 */
	MIDDLE(15),

	/**
	 * 30
	 */
	LARGE(30),

	/**
	 * 100
	 */
	MAX(100);

	public int value;

	private PageSize(int value) {
		this.value = value;
	}
}
