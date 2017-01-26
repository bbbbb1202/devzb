package com.devzb.zufang.service;

import com.devzb.framework.common.bean.PageParam;
import com.devzb.framework.common.bean.SimplePage;
import com.devzb.zufang.dao.dto.ZufangItemDto;

/**
 * 租房service
 * 
 * @author zhangbin
 *
 */
public interface ZufangItemService {

	/**
	 * 获取租房分页数据
	 * 
	 * @param page
	 * @return
	 */
	public SimplePage<ZufangItemDto> getZufangItems(PageParam page);
}
