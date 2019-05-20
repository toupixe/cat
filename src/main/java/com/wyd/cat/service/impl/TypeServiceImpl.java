package com.wyd.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.TypeMapper;
import com.wyd.cat.dto.LifeTypeDto;
import com.wyd.cat.service.TypeService;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

@Service
public class TypeServiceImpl implements TypeService {

	@Autowired
	private TypeMapper typeMapper;
	
	@Override
	public List<LifeTypeDto> getTypeByLifeId(Integer id) throws SystemException, BusinessException{
		return typeMapper.getLifeTypeByLifeId(id);
	}

}
