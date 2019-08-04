package com.wyd.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.LifeUpdateMapper;

import com.wyd.cat.dto.LifeUpdateDto;

import com.wyd.cat.service.LifeUpdateService;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;

@Service
public class LifeUpdateServiceImpl implements LifeUpdateService {

	@Autowired
	private LifeUpdateMapper lifeUpdateMapper;

	@Override
	public List<LifeUpdateDto> getLifeUpdateByLifeId(Integer id) throws SystemException, BusinessException {
		return lifeUpdateMapper.getLifeUpdateByLifeId(id);
	}

	@Override
	public void putOneLifeUpdate(LifeUpdateDto lifeUpdateDto) throws BusinessException{
		lifeUpdateMapper.insertOneLifeUpdate(lifeUpdateDto);
		
	}
}
