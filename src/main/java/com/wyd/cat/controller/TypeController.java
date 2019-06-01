package com.wyd.cat.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wyd.cat.dto.LifeTypeDto;
import com.wyd.cat.model.Life;
import com.wyd.cat.service.TypeService;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.result.CommonResponseType;
import com.wyd.cat.webutils.result.Result;

@Controller
@RequestMapping("/type")
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class TypeController {
	
	@Autowired
	private TypeService typeService;
	
	/**
	 * 
	 * <p>Title: getLifeById</p>  
	 * <p>Description: 获取一个指定id的生活详情数据</p>  
	 * @param lifeId
	 * @return
	 */
	@RequestMapping("/getType")
	@ResponseBody
	public CommonResponseType getType() {
		
		List<LifeTypeDto> lifeTypeDto = null;
		try {
			lifeTypeDto = typeService.getAllType();
		}  catch (BusinessException e) {
			Map<String, Object> map = new HashMap<>();
			map.put("errorCode", e.getErrorCode());
			map.put("errorMsg", e.getErrorMsg());
			return CommonResponseType.create(map, Result.FAIL.getStauts());
		}
		return CommonResponseType.create(lifeTypeDto, Result.SUCCESS.getStauts());
		
	}
	
	/**
	 * 
	 * <p>Title: getLifeById</p>  
	 * <p>Description: 获取一个指定id的生活详情数据</p>  
	 * @param lifeId
	 * @return
	 */
	@RequestMapping("/getTypeByCate")
	@ResponseBody
	public CommonResponseType getTypeByCate(String category) {
		
		List<LifeTypeDto> lifeTypeDto = null;
		try {
			lifeTypeDto = typeService.getTypeByCategory(category);
		}  catch (BusinessException e) {
			Map<String, Object> map = new HashMap<>();
			map.put("errorCode", e.getErrorCode());
			map.put("errorMsg", e.getErrorMsg());
			return CommonResponseType.create(map, Result.FAIL.getStauts());
		}
		return CommonResponseType.create(lifeTypeDto, Result.SUCCESS.getStauts());
		
	}
}
