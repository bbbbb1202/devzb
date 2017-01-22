package com.devzb.tucao.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.devzb.tucao.dao.dto.TucaoItemDto;
import com.devzb.tucao.dao.model.TucaoItemExample;

@Repository
public interface TucaoItemMapperExt extends TucaoItemMapper {

	public List<TucaoItemDto> selectByExampleForDto(TucaoItemExample example);
}