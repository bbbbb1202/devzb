package com.devzb.self.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devzb.framework.common.BaseController;
import com.devzb.framework.common.bean.Protocol;
import com.devzb.self.service.MetalZincService;

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
	private MetalZincService metalZincService;

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

		protocol.setData(metalZincService.getMetalZincPricesForJson());
		
		model.addAttribute(protocol);
		
		return SUCCESS;
	}
}
