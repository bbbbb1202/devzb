package com.devzb.framework.common.bean;

import com.devzb.framework.common.enums.PageSize;

/**
 * 分页参数
 * 
 * @author zhangbin
 *
 */
public class PageParam {

	/**
	 * 页码，从1开始
	 */
	private int	pageNum		= 1;
	/**
	 * 页面大小
	 */
	private int	pageSize	= PageSize.SMALL.value;

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
