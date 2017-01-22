package com.devzb.zufang.dao.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.devzb.zufang.dao.dto.ZufangItemDto;
import com.devzb.zufang.dao.model.ZufangItemExample;


@Repository
public interface ZufangItemMapperExt extends ZufangItemMapper {

	public List<ZufangItemDto> selectByExampleForDto(ZufangItemExample example);
}