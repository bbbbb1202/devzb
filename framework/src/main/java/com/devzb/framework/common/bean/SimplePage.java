
package com.devzb.framework.common.bean;

import java.util.List;

import com.devzb.framework.common.enums.PageSize;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.github.pagehelper.PageInfo;

/**
 * 简单分页对象
 * 
 * @author zhangbin
 *
 * @param <T>
 */
@JsonIgnoreProperties(value = { "endRow", "firstPage", "hasNextPage",
										"hasPreviousPage", "isFirstPage",
										"isLastPage", "lastPage",
										"navigatePages", "navigatepageNums",
										"nextPage", "orderBy", "prePage",
										"size", "startRow" })
public class SimplePage<T> extends PageInfo<T> {

	private static final long serialVersionUID = 8662524494151815339L;

	/**
	 * 包装Page对象，默认页码数量数为8
	 * 
	 * @param list
	 *            page结果
	 */
	public SimplePage(List<T> list) {
		super(list, PageSize.SMALL.value);
	}

	/**
	 * 包装Page对象
	 *
	 * @param list
	 *            page结果
	 * @param navigatePages
	 *            页码数量
	 */
	public SimplePage(List<T> list, int navigatePages) {
		super(list, navigatePages);
	}

}
