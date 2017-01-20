package com.devzb.self.service;

import java.util.List;

import com.devzb.self.dao.dto.ZincJsonDto;
import com.devzb.self.dao.model.MetalZincPrice;

public interface MetalZincService {

	public List<MetalZincPrice> getMetalZincPrices();

	public List<ZincJsonDto> getMetalZincPricesForJson();
}
