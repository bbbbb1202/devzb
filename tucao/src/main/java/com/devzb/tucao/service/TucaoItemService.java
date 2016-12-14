package com.devzb.tucao.service;

import com.devzb.framework.common.bean.SimplePage;
import com.devzb.tucao.dao.dto.TucaoItemDto;
import com.github.pagehelper.Page;

/**
 * 吐槽service
 * 
 * @author zhangbin
 *
 */
public interface TucaoItemService {

	/**
	 * 获取吐槽分页数据
	 * 
	 * @param page
	 * @return
	 */
	public SimplePage<TucaoItemDto> getTucaoItems(Page<TucaoItemDto> page);
}
