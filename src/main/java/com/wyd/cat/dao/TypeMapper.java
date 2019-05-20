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

}
