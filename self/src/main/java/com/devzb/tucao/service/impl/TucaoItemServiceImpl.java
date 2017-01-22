
package com.devzb.tucao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.devzb.framework.common.BaseService;
import com.devzb.framework.common.bean.SimplePage;
import com.devzb.framework.common.enums.PageSize;
import com.devzb.tucao.dao.dto.TucaoItemDto;
import com.devzb.tucao.dao.mapper.TucaoItemMapperExt;
import com.devzb.tucao.dao.model.TucaoItem;
import com.devzb.tucao.service.TucaoItemService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

@Service
public class TucaoItemServiceImpl extends BaseService
										implements TucaoItemService {

	@Resource
	private TucaoItemMapperExt tucaoItemMapperExt;

	@Override
	public SimplePage<TucaoItemDto> getTucaoItems(Page<TucaoItemDto> page) {

		if (1 == page.getPageNum()) {// 初始化（第一次）页码数量设置成100
			page.setPageSize(PageSize.MAX.value);
		}

		PageHelper.startPage(page.getPageNum(), page.getPageSize(), "sort_num desc");

		List<TucaoItemDto> list = tucaoItemMapperExt.selectByExampleForDto(null);

		return new SimplePage<>(list, page.getPageSize());
	}

	@Override
	public TucaoItem saveTucaoItem(TucaoItem tucaoItem) {

		if (tucaoItem.getLongitude() != null) {
			tucaoItem.setLongitude(tucaoItem.getLongitude() * 1000000);
		}
		if (tucaoItem.getLatitude() != null) {
			tucaoItem.setLatitude(tucaoItem.getLatitude() * 1000000);
		}
		tucaoItem.setId(null);
		tucaoItemMapperExt.insertSelective(tucaoItem);

		return tucaoItem;
	}
}
