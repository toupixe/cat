package com.wyd.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.LifeMapper;
import com.wyd.cat.dto.LifeDto;
import com.wyd.cat.service.LifeService;


@Service
public class LifeImpl implements LifeService {
	
	@Autowired
	private LifeMapper lifeMapper;
	
	@Override
	public List<LifeDto> getLifeList() {
		return lifeMapper.selectLifeLst();
	}

	@Override
	public LifeDto getLifeById(String lifeId) {
		return lifeMapper.getLifeById(Integer.parseInt(lifeId));
		
	}

}
