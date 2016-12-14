package com.devzb.tucao.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.devzb.tucao.dao.dto.TucaoItemDto;
import com.devzb.tucao.dao.param.TucaoItemParam;

@Repository
public interface TucaoItemMapperExt extends TucaoItemMapper {

	public List<TucaoItemDto> getTucaoItems(TucaoItemParam param);
}