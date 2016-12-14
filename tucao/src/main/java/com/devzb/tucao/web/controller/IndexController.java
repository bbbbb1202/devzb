package com.devzb.tucao.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devzb.framework.common.BaseController;
import com.devzb.framework.common.bean.Protocol;
import com.devzb.tucao.dao.dto.TucaoItemDto;
import com.devzb.tucao.service.TucaoItemService;
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
	private TucaoItemService tucaoItemService;

	@RequestMapping(value = { "", "index" })
	public String index(Model model) {
		return "index";
	}

	/**
	 * 吐槽页面
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "tucao" })
	public String tucao(Model model) {
		return "tucao";
	}

	/**
	 * 吐槽数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = { "tucao/data" })
	public String tucaoData(Model model, Page<TucaoItemDto> page) {

		Protocol protocol = new Protocol();
		protocol.setData(tucaoItemService.getTucaoItems(page));

		model.addAttribute(protocol);

		return SUCCESS;
	}
}
