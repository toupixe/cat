package com.wyd.cat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wyd.cat.dto.LifeUpdateDto;

@Repository
public interface LifeUpdateMapper {

	/**
	 * 
	 * <p>Title: getLifeCommentByLifeId</p>  
	 * <p>Description: 通过生活主键id获取所有更新履历</p>  
	 * @param id
	 * @return
	 */
	List<LifeUpdateDto> getLifeUpdateByLifeId(Integer id);
	
	/**
	 * 插入一条生活的更新日志
	 * @param lifeUpdateDto
	 */
	void insertOneLifeUpdate(@Param("lifeUpdateDto") LifeUpdateDto lifeUpdateDto);

}
