package com.wyd.cat.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.ContactMapper;
import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.service.IndexService;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

@Service
public class ContactImpl implements IndexService {
	
	@Autowired
	private ContactMapper contactMapper;
	
	@Override
	public void saveContact(ContactDto contactDto) throws SystemException,BusinessException {
		contactMapper.insertContact(contactDto);
		
	}

}
