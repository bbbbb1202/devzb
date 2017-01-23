package com.devzb.note.service;

import com.devzb.framework.common.bean.SimplePage;
import com.devzb.note.dao.model.NoteItem;
import com.github.pagehelper.Page;

/**
 * 笔记service
 * 
 * @author zhangbin
 *
 */
public interface NoteService {

	/**
	 * 获取笔记列表
	 * 
	 * @param page
	 * @return
	 */
	public SimplePage<NoteItem> getNotes(Page<NoteItem> page);

	/**
	 * 保存笔记
	 * 
	 * @param noteItem
	 * @return
	 */
	public NoteItem saveNote(NoteItem noteItem);
}
