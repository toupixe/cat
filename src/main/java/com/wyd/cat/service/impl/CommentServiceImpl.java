package com.wyd.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.CommentMapper;
import com.wyd.cat.dto.CommentDto;
import com.wyd.cat.service.CommentService;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

@Service
public class CommentServiceImpl implements CommentService {

	@Autowired
	private CommentMapper commentMapper;

	@Override
	public List<CommentDto> getLifeCommentByLifeId(Integer id) throws SystemException, BusinessException {
		return commentMapper.getLifeCommentByLifeId(id);
	}
	

}
