package com.wyd.cat.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wyd.cat.dto.CommentDto;

@Repository
public interface CommentMapper {

	/**
	 * 
	 * <p>Title: getLifeCommentByLifeId</p>  
	 * <p>Description: 通过生活主键id获取所有评论</p>  
	 * @param id
	 * @return
	 */
	List<CommentDto> getLifeCommentByLifeId(Integer id);

}
