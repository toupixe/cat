package com.wyd.cat.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.ImgMapper;
import com.wyd.cat.dto.ImgDto;

import com.wyd.cat.service.ImgService;

import com.wyd.cat.webutils.exception.BusinessException;


@Service
public class ImgImpl implements ImgService {
	
	@Autowired
	private ImgMapper imgMapper;
	
	@Override
	public void save(ImgDto imgDto) throws BusinessException {
		imgMapper.insert(imgDto);
	}
	
	

}
