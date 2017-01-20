package com.devzb.self.service;

import com.devzb.framework.common.bean.SimplePage;
import com.devzb.self.dao.model.NoteItem;

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
	 * @param pageNum
	 * @return
	 */
	public SimplePage<NoteItem> getNotes(Integer pageNum);

	/**
	 * 保存笔记
	 * 
	 * @param noteItem
	 * @return
	 */
	public NoteItem saveNote(NoteItem noteItem);
}
