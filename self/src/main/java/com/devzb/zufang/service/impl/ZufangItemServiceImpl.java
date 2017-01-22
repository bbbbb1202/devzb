package com.devzb.zufang.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.devzb.framework.common.BaseService;
import com.devzb.framework.common.bean.SimplePage;
import com.devzb.framework.common.enums.PageSize;
import com.devzb.zufang.dao.dto.ZufangItemDto;
import com.devzb.zufang.dao.mapper.ZufangItemMapperExt;
import com.devzb.zufang.service.ZufangItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class ZufangItemServiceImpl extends BaseService
										implements ZufangItemService {

	@Resource
	private ZufangItemMapperExt zufangItemMapperExt;
	
	@Override
	public SimplePage<ZufangItemDto> getZufangItems(Page<ZufangItemDto> page) {

		if (1 == page.getPageNum()) {// 初始化（第一次）页码数量设置成100
			page.setPageSize(PageSize.MAX.value);
		}

		PageHelper.startPage(page.getPageNum(), page.getPageSize(), "sort_num desc");

		List<ZufangItemDto> list = zufangItemMapperExt.selectByExampleForDto(null);

		return new SimplePage<>(list, page.getPageSize());
	}

}
