package com.wyd.cat.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.LifeMapper;
import com.wyd.cat.dto.CommentDto;
import com.wyd.cat.dto.LifeDto;
import com.wyd.cat.dto.LifeTypeDto;
import com.wyd.cat.dto.LifeUpdateDto;
import com.wyd.cat.model.Life;
import com.wyd.cat.service.CommentService;
import com.wyd.cat.service.LifeService;
import com.wyd.cat.service.LifeUpdateService;
import com.wyd.cat.service.TypeService;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;


@Service
public class LifeImpl implements LifeService {
	
	@Autowired
	private LifeMapper lifeMapper;
	
	@Autowired
	private LifeUpdateService lifeUpdateService;
	
	@Autowired
	private TypeService TypeService;
	
	@Autowired
	private CommentService commentService;
	
	@Override
	public List<LifeDto> getLifeList() throws SystemException, BusinessException {
		return lifeMapper.selectLifeLst(null);
	}

	@Override
	public LifeDto getLifeById(String lifeId) throws SystemException, BusinessException{
		LifeDto lifeDto = null;
		//查询生活详情主信息
		lifeDto = lifeMapper.getLifeById(Integer.parseInt(lifeId));
		
		if(lifeDto != null) {
			//查询生活标签
			List<LifeTypeDto> lifeTypeDtoLst= TypeService.getTypeByLifeId(Integer.parseInt(lifeId));
			lifeDto.setLifeTypeLst(lifeTypeDtoLst);
			
			//查询生活评论
			List<CommentDto> commentDtoLst = commentService.getLifeCommentByLifeId(Integer.parseInt(lifeId));
			lifeDto.setCommentLst(commentDtoLst);
			
			//查询生活更新履历
			List<LifeUpdateDto> LifeUpdateDtoLst = lifeUpdateService.getLifeUpdateByLifeId(Integer.parseInt(lifeId));
			lifeDto.setLifeUpdateLst(LifeUpdateDtoLst);
		}
		return lifeDto;
		
	}

	@Override
	public List<LifeDto> getLifeList(String lifeType) throws SystemException, BusinessException {
		return lifeMapper.selectLifeLst(lifeType);
	}

	@Override
	public void save(Life life) throws BusinessException {
		lifeMapper.insert(life);
		
	}

}
