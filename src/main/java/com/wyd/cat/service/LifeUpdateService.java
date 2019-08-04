package com.wyd.cat.service;

import java.util.List;

import com.wyd.cat.dto.LifeUpdateDto;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

public interface LifeUpdateService {
	/**
	 * 
	 * <p>Title: getLifeUpdateByLifeId</p>  
	 * <p>Description: 通过生活id获取当前该数据更新信息</p>  
	 * @return
	 */
	public List<LifeUpdateDto>getLifeUpdateByLifeId(Integer id)throws SystemException, BusinessException;
	
	/**
	 * 插入一条生活的更新日志
	 * @param lifeUpdateDto
	 */
	public void putOneLifeUpdate(LifeUpdateDto lifeUpdateDto)throws BusinessException;
}
