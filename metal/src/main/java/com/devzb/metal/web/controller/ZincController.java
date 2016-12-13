package com.devzb.metal.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devzb.framework.bean.Protocol;
import com.devzb.framework.web.controller.BaseController;
import com.devzb.metal.service.ZincService;

/**
 * 锌
 * 
 * @author zhangbin
 *
 */
@Controller
@RequestMapping("zinc")
public class ZincController extends BaseController {

	@Resource
	private ZincService zincService;

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		return "zinc";
	}

	/**
	 * 锌json数据
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "data")
	public String getJsonData(Model model) {

		Protocol protocol = new Protocol();

		protocol.setData(zincService.getMetalZincPricesForJson());
		
		model.addAttribute(protocol);
		
		return SUCCESS;
	}
}
