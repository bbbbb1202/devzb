package com.devzb.self.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devzb.framework.common.BaseController;

/**
 * 金属平台
 * 
 * @author zhangbin
 *
 */
@Controller
@RequestMapping("metal")
public class MetalController extends BaseController {

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "")
	public String index(Model model) {
		return "metal/index";
	}
}
