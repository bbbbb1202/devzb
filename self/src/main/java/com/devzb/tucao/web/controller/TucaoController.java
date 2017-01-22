package com.devzb.tucao.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devzb.framework.common.BaseController;
import com.devzb.framework.common.bean.Protocol;
import com.devzb.tucao.dao.dto.TucaoItemDto;
import com.devzb.tucao.service.TucaoItemService;
import com.github.pagehelper.Page;

/**
 * 吐槽
 * 
 * @author zhangbin
 *
 */
@Controller
@RequestMapping("tucao")
public class TucaoController extends BaseController {

	@Resource
	private TucaoItemService tucaoItemService;

	/**
	 * 吐槽页面
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		return "tucao/index";
	}

	/**
	 * 吐槽数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "data")
	public String tucaoData(Model model, Page<TucaoItemDto> page) {

		Protocol protocol = new Protocol();
		protocol.setData(tucaoItemService.getTucaoItems(page));

		model.addAttribute(protocol);

		return SUCCESS;
	}
}
