package com.wyd.cat.service;

import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

public interface IndexService {
	/**
	 * 
	 * <p>Title: saveContact</p>  
	 * <p>Description:保存联络信息 </p>  
	 * @param contactDto 联络信息对象
	 * @throws SystemException 系统异常
	 * @throws BusinessException 业务异常
	 */
	public void saveContact(ContactDto contactDto) throws SystemException, BusinessException;
}
