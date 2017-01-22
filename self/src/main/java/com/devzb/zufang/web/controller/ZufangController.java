
package com.devzb.zufang.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devzb.framework.common.BaseController;
import com.devzb.framework.common.bean.Protocol;
import com.devzb.zufang.dao.dto.ZufangItemDto;
import com.devzb.zufang.service.ZufangItemService;
import com.github.pagehelper.Page;

/**
 * 租房
 * 
 * @author zhangbin
 *
 */
@Controller
@RequestMapping("zufang")
public class ZufangController extends BaseController {

	@Resource
	private ZufangItemService zufangItemService;

	/**
	 * 租房页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		return "zufang/index";
	}

	/**
	 * 租房数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "data")
	public String zufangData(Model model, Page<ZufangItemDto> page) {

		Protocol protocol = new Protocol();
		protocol.setData(zufangItemService.getZufangItems(page));

		model.addAttribute(protocol);

		return SUCCESS;
	}
}
