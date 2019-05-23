package com.wyd.cat.service;

import java.util.List;

import com.wyd.cat.dto.LifeTypeDto;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

public interface TypeService {
	/**
	 * 
	 * <p>Title: getTypeByLifeId</p>  
	 * <p>Description: 通过生活主键id获取当前生活所具有的标签</p>  
	 * @param id
	 * @return
	 */
	List<LifeTypeDto>getTypeByLifeId(Integer id)throws SystemException, BusinessException;
	
	/**
	 * 
	 * <p>Title: getTypeByLifeId</p>  
	 * <p>Description: 通过生活主键id获取当前生活所具有的标签</p>  
	 * @param id
	 * @return
	 */
	List<LifeTypeDto>getAllType()throws BusinessException;

	/**
	 * 
	 * <p>Title: getTypeByCategory</p>  
	 * <p>Description: 通过type分类查询type</p>  
	 * @param category
	 * @return
	 */
	List<LifeTypeDto> getTypeByCategory(String category)throws BusinessException;
}
