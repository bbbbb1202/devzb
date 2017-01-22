package com.devzb.self.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.devzb.framework.common.BaseController;

@Controller
@RequestMapping
public class IndexController extends BaseController {

	@RequestMapping(value = "")
	public String index(Model model) {
		return "login";
	}
}
