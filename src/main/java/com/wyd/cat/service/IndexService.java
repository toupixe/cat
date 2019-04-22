package com.wyd.cat.service;

import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.exception.BusinessException;
import com.wyd.cat.exception.SystemException;

public interface IndexService {
	/**将联系人保存
	 * @throws SystemException 
	 * @throws BusinessException */
	public void saveContact(ContactDto contactDto) throws SystemException, BusinessException;
}
