package com.devzb.note.web.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.devzb.framework.common.BaseController;
import com.devzb.framework.common.bean.Protocol;
import com.devzb.note.dao.model.NoteItem;
import com.devzb.note.service.NoteService;
import com.github.pagehelper.Page;

/**
 * 笔记controller
 * 
 * @author zhangbin
 *
 */
@Controller
@RequestMapping("note")
public class NoteController extends BaseController {

	@Resource
	private NoteService noteService;

	/**
	 * 首页
	 * 
	 * @param model
	 * @return
	 */
	@RequestMapping(value = "", method = RequestMethod.GET)
	public String index(Model model) {
		return "note/note";
	}

	/**
	 * 笔记json数据
	 * 
	 * @param model
	 * @param page
	 * @return
	 */
	@RequestMapping(value = "data")
	public String getJsonData(Model model, Page<NoteItem> page) {

		Protocol protocol = new Protocol();

		protocol.setData(noteService.getNotes(page));
		
		model.addAttribute(protocol);
		
		return SUCCESS;
	}

	@RequestMapping(value = "save", method = RequestMethod.POST)
	public String saveNote(Model model, NoteItem noteItem) {

		Protocol protocol = new Protocol();

		protocol.setData(noteService.saveNote(noteItem));

		model.addAttribute(protocol);

		return SUCCESS;
	}
}
