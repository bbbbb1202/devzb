package com.devzb.note.service.impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import com.devzb.framework.common.bean.SimplePage;
import com.devzb.framework.common.enums.PageSize;
import com.devzb.framework.common.exception.ValidateException;
import com.devzb.note.dao.mapper.NoteItemMapperExt;
import com.devzb.note.dao.mapper.NoteItemTagMapperExt;
import com.devzb.note.dao.mapper.NoteTagMapperExt;
import com.devzb.note.dao.model.NoteItem;
import com.devzb.note.dao.model.NoteItemExample;
import com.devzb.note.dao.model.NoteItemTag;
import com.devzb.note.dao.model.NoteItemTagExample;
import com.devzb.note.dao.model.NoteTag;
import com.devzb.note.dao.model.NoteTagExample;
import com.devzb.note.service.NoteService;
import com.github.pagehelper.PageHelper;

@Service
public class NoteServiceImpl implements NoteService {

	@Resource
	private NoteItemMapperExt		noteItemMapperExt;
	@Resource
	private NoteItemTagMapperExt	noteItemTagMapperExt;
	@Resource
	private NoteTagMapperExt		noteTagMapperExt;

	@Override
	public SimplePage<NoteItem> getNotes(Integer pageNum) {
		if (pageNum == null) {
			pageNum = 1;
		}
		PageHelper.startPage(pageNum, PageSize.LARGE.value, "gmt_created desc");

		NoteItemExample example = new NoteItemExample();

		List<NoteItem> list = noteItemMapperExt.selectByExample(example);

		return new SimplePage<>(list);
	}

	@Override
	public NoteItem saveNote(NoteItem noteItem) {
		if(noteItem == null){
			throw new ValidateException(200444);
		}
		// 210101 = 笔记标题不能为空
		// 210102 = 笔记标题太长
		// 210103 = 笔记标签不能为空
		// 210104 = 笔记标签太长
		// 210105 = 笔记内容不能为空
		// 210106 = 笔记内容太长
		if (StringUtils.isBlank(noteItem.getTitle())) {
			throw new ValidateException(210101, "笔记标题不能为空");
		}
		if (noteItem.getTitle().length() > 32) {
			throw new ValidateException(210102, "笔记标题太长");
		}
		if (StringUtils.isBlank(noteItem.getTags())) {
			throw new ValidateException(210103, "笔记标签不能为空");
		}
		if (noteItem.getTags().length() > 32) {
			throw new ValidateException(210104, "笔记标签太多");
		}
		if (StringUtils.isBlank(noteItem.getContent())) {
			throw new ValidateException(210105, "笔记内容不能为空");
		}
		if (noteItem.getContent().length() > 1024000) {
			throw new ValidateException(210106, "笔记内容太长");
		}

		String tags[] = noteItem.getTags().split(",");
		if (tags.length > 10) {
			throw new ValidateException(210104, "笔记标签太多，请少于10个");
		}

		if (noteItem.getId() != null) {// 如果是修改，先删除
			NoteItemTagExample example = new NoteItemTagExample();
			example.createCriteria().andItemIdEqualTo(noteItem.getId());
			noteItemTagMapperExt.deleteByExample(example);

			// 更新笔记
			noteItemMapperExt.updateByPrimaryKeyWithBLOBs(noteItem);
		} else {
			// 新增笔记
			noteItemMapperExt.insertSelective(noteItem);
		}

		Date now = new Date();

		NoteTagExample noteTagExample = new NoteTagExample();
		NoteTag noteTag = null;
		for (String tag : tags) {
			if (StringUtils.isBlank(tag)) {
				continue;
			}
			noteTagExample.createCriteria().andTagEqualTo(tag);
			List<NoteTag> noteTags = noteTagMapperExt.selectByExample(noteTagExample);

			NoteItemTag noteItemTag = new NoteItemTag();

			if (noteTags.size() == 0) {
				noteTag = new NoteTag();
				noteTag.setTag(tag);
				noteTag.setGmtCreated(now);
				noteTagMapperExt.insertSelective(noteTag);

				noteItemTag.setItemId(noteItem.getId());
				noteItemTag.setTagId(noteTag.getId());
			} else {
				noteItemTag.setItemId(noteItem.getId());
				noteItemTag.setTagId(noteTags.get(0).getId());
			}
			noteItemTagMapperExt.insertSelective(noteItemTag);
		}
		return noteItem;
	}
}
