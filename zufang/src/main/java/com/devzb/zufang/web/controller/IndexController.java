package com.devzb.zufang.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devzb.framework.common.BaseController;
import com.devzb.framework.common.bean.Protocol;
import com.devzb.zufang.dao.dto.ZufangItemDto;
import com.devzb.zufang.service.ZufangItemService;
import com.github.pagehelper.Page;

/**
 * 首页controller
 * 
 * @author zhangbin
 *
 */
@Controller
public class IndexController extends BaseController {

	@Resource
	private ZufangItemService zufangItemService;

	@RequestMapping(value = { "", "index" })
	public String index(Model model) {
		return "index";
	}

	/**
	 * 租房页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "zufang" })
	public String zufang(Model model) {
		return "zufang";
	}

	/**
	 * 租房数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "zufang/data" })
	public String zufangData(Model model, Page<ZufangItemDto> page) {

		Protocol protocol = new Protocol();
		protocol.setData(zufangItemService.getZufangItems(page));

		model.addAttribute(protocol);

		return SUCCESS;
	}
}
