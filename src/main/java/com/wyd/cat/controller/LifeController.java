package com.wyd.cat.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyd.cat.dto.LifeDto;
import com.wyd.cat.service.LifeService;
import com.wyd.cat.webutils.error.errornum.EmBusinessError;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;
import com.wyd.cat.webutils.result.CommonResponseType;
import com.wyd.cat.webutils.result.Result;

/**
 * 
* @Description:  关于生活控制器
* @author 王
* @date 2019年4月9日
 */
@Controller
@RequestMapping("/life")
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class LifeController extends BaseController{
	
	@Autowired
	private LifeService lifeService;
	
	/**
	 * 
	 * <p>Title: getLifeLst</p>  
	 * <p>Description: 获取关于生活的列表信息</p>  
	 * @return CommonResponseType 封装返回信息的类
	 */
	@RequestMapping("/getLifeLst")
	@ResponseBody
	public CommonResponseType getLifeLst() {
		List<LifeDto> lifeList = null;
		try {
			lifeList = lifeService.getLifeList();
			if (lifeList == null) {
				Map<String,Object> errorMap = new HashMap<>();
				errorMap.put("errorMsg", EmBusinessError.LIFE_NOT_EXCIT.getErrorMsg());
				errorMap.put("errorCode", EmBusinessError.LIFE_NOT_EXCIT.getErrorCode());
				return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
			}
			return CommonResponseType.create(lifeList, Result.SUCCESS.getStauts());
		} catch (SystemException e) {
			Map<String,Object> errorMap = new HashMap<>();
			errorMap.put("errorMsg", EmBusinessError.SENT_CONTACT_ERROR.getErrorMsg());
			errorMap.put("errorCode", EmBusinessError.SENT_CONTACT_ERROR.getErrorCode());
			return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
		} catch (BusinessException e) {
			Map<String,Object> errorMap = new HashMap<>();
			errorMap.put("errorMsg", EmBusinessError.SENT_CONTACT_ERROR.getErrorMsg());
			errorMap.put("errorCode", EmBusinessError.SENT_CONTACT_ERROR.getErrorCode());
			return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
		}
	}
	
	/**
	 * 
	 * <p>Title: getLifeLst</p>  
	 * <p>Description: 通过lifeType获取关于生活的列表信息</p>  
	 * @return CommonResponseType 封装返回信息的类
	 */
	@RequestMapping("/getLifeLstByLifeType")
	@ResponseBody
	public CommonResponseType getLifeLst(String lifeType) {
		List<LifeDto> lifeList = null;
		try {
			lifeList = lifeService.getLifeList(lifeType);
			if (lifeList == null) {
				Map<String,Object> errorMap = new HashMap<>();
				errorMap.put("errorMsg", EmBusinessError.LIFE_NOT_EXCIT.getErrorMsg());
				errorMap.put("errorCode", EmBusinessError.LIFE_NOT_EXCIT.getErrorCode());
				return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
			}
			return CommonResponseType.create(lifeList, Result.SUCCESS.getStauts());
		} catch (SystemException e) {
			Map<String,Object> errorMap = new HashMap<>();
			errorMap.put("errorMsg", EmBusinessError.SENT_CONTACT_ERROR.getErrorMsg());
			errorMap.put("errorCode", EmBusinessError.SENT_CONTACT_ERROR.getErrorCode());
			return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
		} catch (BusinessException e) {
			Map<String,Object> errorMap = new HashMap<>();
			errorMap.put("errorMsg", EmBusinessError.SENT_CONTACT_ERROR.getErrorMsg());
			errorMap.put("errorCode", EmBusinessError.SENT_CONTACT_ERROR.getErrorCode());
			return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
		}
	}
	
	
	
	/**
	 * 
	 * <p>Title: getLifeById</p>  
	 * <p>Description: 获取一个指定id的生活详情数据</p>  
	 * @param lifeId
	 * @return
	 */
	@RequestMapping("/getLife")
	@ResponseBody
	public CommonResponseType getLifeById(String lifeId) {
		LifeDto LifeDto = null;
		try {
			LifeDto = lifeService.getLifeById(lifeId);
		} catch (SystemException e) {
			Map<String,Object> errorMap = new HashMap<>();
			errorMap.put("errorMsg", EmBusinessError.SENT_CONTACT_ERROR.getErrorMsg());
			errorMap.put("errorCode", EmBusinessError.SENT_CONTACT_ERROR.getErrorCode());
			return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
		} catch (BusinessException e) {
			Map<String,Object> errorMap = new HashMap<>();
			errorMap.put("errorMsg", EmBusinessError.SENT_CONTACT_ERROR.getErrorMsg());
			errorMap.put("errorCode", EmBusinessError.SENT_CONTACT_ERROR.getErrorCode());
			return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
		}
		return CommonResponseType.create(LifeDto, Result.SUCCESS.getStauts());
	}
	
	/**
	 * 
	 * <p>Title: getLifeById</p>  
	 * <p>Description: 获取一个指定id的生活详情数据</p>  
	 * @param lifeId
	 * @return
	 */
	@RequestMapping("/uploadLifePic")
	@ResponseBody
	public CommonResponseType uploadLifePic(String lifeId) {
		return null;
		
	}
}
