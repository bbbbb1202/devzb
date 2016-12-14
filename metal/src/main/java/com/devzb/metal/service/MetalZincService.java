package com.devzb.metal.service;

import java.util.List;

import com.devzb.metal.dao.dto.ZincJsonDto;
import com.devzb.metal.dao.model.MetalZincPrice;

public interface MetalZincService {

	public List<MetalZincPrice> getMetalZincPrices();

	public List<ZincJsonDto> getMetalZincPricesForJson();
}
