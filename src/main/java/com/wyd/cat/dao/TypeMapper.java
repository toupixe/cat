package com.wyd.cat.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wyd.cat.dto.LifeTypeDto;

@Repository
public interface TypeMapper {

	/**
	 * 
	 * <p>Title: getLifeTypeByLifeId</p>  
	 * <p>Description: 通过生活主键id获取它所有的标签</p>  
	 * @return
	 */
	List<LifeTypeDto> getLifeTypeByLifeId(@Param("lifeId") Integer lifeId);

	/**
	 * 
	 * <p>Title: getAllType</p>  
	 * <p>Description:获取所有标签 </p>  
	 * @return
	 */
	List<LifeTypeDto> getAllType();

	/**
	 * 
	 * <p>Title: getTypeByCategory</p>  
	 * <p>Description: 通过Type分类查询type对象</p>  
	 * @param category
	 * @return
	 */
	List<LifeTypeDto> getTypeByCategory(@Param("category") String category);
	
	/**
	 * 插入一条生活标签
	 * @param lifeTypeDto
	 */
	void insertOneLifeType(@Param("lifeTypeDto") LifeTypeDto lifeTypeDto);

}
