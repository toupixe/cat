package com.wyd.cat.service;

import java.util.List;

import com.wyd.cat.dto.LifeDto;
import com.wyd.cat.model.Life;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

/**
 * 
* @Description:生活业务层 
* @author 王
* @date 2019年5月16日
 */
public interface LifeService {
	/**
	 * 
	 * <p>Title: getLifeList</p>  
	 * <p>Description: 获取一个前10的生活的数据list</p>  
	 * @return
	 */
	public List<LifeDto> getLifeList() throws SystemException, BusinessException;

	/**
	 * 
	 * <p>Title: getLifeById</p>  
	 * <p>Description: 根据生活主键获取生活文章</p>  
	 * @param lifeId
	 */
	public LifeDto getLifeById(String lifeId)throws SystemException, BusinessException;

	/**
	 * 
	 * <p>Title: getLifeList</p>  
	 * <p>Description: 通过LifeType获取一个前10的生活的数据list</p>  
	 * @return
	 */
	public List<LifeDto> getLifeList(String lifeType)throws SystemException, BusinessException;

	/**
	 * 
	 * <p>Title: save</p>  
	 * <p>Description: 保存一个life对象</p>  
	 * @param life
	 * @throws SystemException
	 * @throws BusinessException
	 */
	public void save(Life life)throws BusinessException;
	
}
