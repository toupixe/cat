package com.wyd.cat.service;

import java.util.List;

import com.wyd.cat.dto.CommentDto;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

public interface CommentService {
	
	/**
	 * 
	 * <p>Title: getLifeCommentByLifeId</p>  
	 * <p>Description: 通过生活id获取相关评论</p>  
	 * @return
	 */
	public List<CommentDto>getLifeCommentByLifeId(Integer id)throws SystemException, BusinessException;
}
