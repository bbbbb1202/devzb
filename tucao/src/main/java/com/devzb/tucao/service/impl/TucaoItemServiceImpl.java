package com.devzb.tucao.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.devzb.tucao.dao.mapper.TucaoItemMapperExt;
import com.devzb.tucao.service.TucaoItemService;

@Service
public class TucaoItemServiceImpl implements TucaoItemService {

	@Resource
	private TucaoItemMapperExt tucaoItemMapperExt;
}
