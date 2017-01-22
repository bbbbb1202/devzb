package com.devzb.tucao.dao.dto;

import java.util.Date;

import com.devzb.framework.common.serializer.CustomDateSerializer;
import com.devzb.tucao.dao.model.TucaoItem;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class TucaoItemDto extends TucaoItem {

	@Override
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getGmtCreated() {
		return super.getGmtCreated();
	}
}
