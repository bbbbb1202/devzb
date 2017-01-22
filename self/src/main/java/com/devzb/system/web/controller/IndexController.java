package com.devzb.system.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devzb.framework.common.BaseController;

@Controller
@RequestMapping
public class IndexController extends BaseController {

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		return "login";
	}
}
