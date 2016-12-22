
package com.devzb.zufang.dao.dto;

import java.util.Date;

import com.devzb.framework.common.serializer.CustomDateSerializer;
import com.devzb.zufang.dao.model.ZufangItem;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

public class ZufangItemDto extends ZufangItem {

	@Override
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getGmtCreated() {
		return super.getGmtCreated();
	}

	@Override
	@JsonSerialize(using = CustomDateSerializer.class)
	public Date getGmtModified() {
		return super.getGmtModified();
	}
}
