package com.devzb.metal.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.devzb.metal.dao.dto.ZincJsonDto;
import com.devzb.metal.dao.mapper.MetalZincPriceMapperExt;
import com.devzb.metal.dao.model.MetalZincPrice;
import com.devzb.metal.dao.model.MetalZincPriceExample;
import com.devzb.metal.service.ZincService;
import com.github.pagehelper.PageHelper;

@Service
public class ZincServiceImpl implements ZincService {

	@Resource
	private MetalZincPriceMapperExt metalZincPriceMapperExt;

	public List<MetalZincPrice> getMetalZincPrices() {
		PageHelper.startPage(1, 8);

		MetalZincPriceExample example = new MetalZincPriceExample();
		example.setOrderByClause("date_day desc");
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
