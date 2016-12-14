
package com.devzb.framework.common.enums;

/**
 * 页码数量枚举
 * 
 * @author zhangbin
 *
 */
public enum PageSize {

	/**
	 * 小
	 */
	SMALL(8),

	/**
	 * 中
	 */
	MIDDLE(15),

	/**
	 * 大
	 */
	LARGE(30),

	/**
	 * 最大
	 */
	MAX(100);

	public int value;

	private PageSize(int value) {
		this.value = value;
	}
}
