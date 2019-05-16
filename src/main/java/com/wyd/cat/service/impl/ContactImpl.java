package com.wyd.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.ContactMapper;
import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.service.ContactService;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

@Service
public class ContactImpl implements ContactService {
	
	@Autowired
	private ContactMapper contactMapper;
	
	@Override
	public void saveContact(ContactDto contactDto) throws SystemException,BusinessException {
		contactMapper.insertContact(contactDto);
		
	}

}
