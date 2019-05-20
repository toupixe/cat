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
}
