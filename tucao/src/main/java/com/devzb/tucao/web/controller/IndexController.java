package com.devzb.tucao.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devzb.framework.common.BaseController;

/**
 * 首页controller
 * 
 * @author zhangbin
 *
 */
@Controller
public class IndexController extends BaseController {

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
	public String tucaoData(Model model) {
		return SUCCESS;
	}
}
