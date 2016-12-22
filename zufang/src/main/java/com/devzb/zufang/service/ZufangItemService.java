package com.devzb.zufang.service;

import com.devzb.framework.common.bean.SimplePage;
import com.devzb.zufang.dao.dto.ZufangItemDto;
import com.github.pagehelper.Page;

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
	public SimplePage<ZufangItemDto> getZufangItems(Page<ZufangItemDto> page);
}
