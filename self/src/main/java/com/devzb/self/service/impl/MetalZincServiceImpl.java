package com.devzb.self.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.devzb.framework.common.BaseService;
import com.devzb.framework.common.enums.PageSize;
import com.devzb.self.dao.dto.ZincJsonDto;
import com.devzb.self.dao.mapper.MetalZincPriceMapperExt;
import com.devzb.self.dao.model.MetalZincPrice;
import com.devzb.self.dao.model.MetalZincPriceExample;
import com.devzb.self.service.MetalZincService;
import com.github.pagehelper.PageHelper;

@Service
public class MetalZincServiceImpl extends BaseService implements MetalZincService {

	@Resource
	private MetalZincPriceMapperExt metalZincPriceMapperExt;

	public List<MetalZincPrice> getMetalZincPrices() {

		PageHelper.startPage(1, PageSize.SMALL.value, "date_day desc");

		MetalZincPriceExample example = new MetalZincPriceExample();
		List<MetalZincPrice> list = metalZincPriceMapperExt
				.selectByExample(example);

		return list;
	}

	public List<ZincJsonDto> getMetalZincPricesForJson() {
		List<MetalZincPrice> list = getMetalZincPrices();

		List<ZincJsonDto> data = new ArrayList<ZincJsonDto>();

		for (int i = list.size(); i > 0 ; i--) {
			ZincJsonDto zincJsonDto = new ZincJsonDto();
			zincJsonDto.setUnit(list.get(i - 1).getDateDay());
			zincJsonDto.setValue(list.get(i - 1).getPrice() / 10000 + "");
			data.add(zincJsonDto);
		}

		return data;
	}
}
