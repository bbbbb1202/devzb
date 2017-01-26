package com.devzb.tucao.service;

import com.devzb.framework.common.bean.PageParam;
import com.devzb.framework.common.bean.SimplePage;
import com.devzb.tucao.dao.dto.TucaoItemDto;
import com.devzb.tucao.dao.model.TucaoItem;

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
	public SimplePage<TucaoItemDto> getTucaoItems(PageParam page);

	public TucaoItem saveTucaoItem(TucaoItem tucaoItem);
}
