package com.wyd.cat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.alibaba.fastjson.JSONObject;
import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.dto.UserDto;
import com.wyd.cat.service.IndexService;
import com.wyd.cat.webutils.error.errornum.EmBusinessError;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;
import com.wyd.cat.webutils.result.CommonResponseType;
import com.wyd.cat.webutils.result.Result;
import com.wyd.cat.webutils.utils.RedisUtils;

@Controller
@RequestMapping("/index")
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class IndexController extends BaseController{
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private IndexService indexService;
	
	@Autowired
	private RedisUtils redisUtils;
	
	/**
	 * 发送联系人信息
	 * */
	@RequestMapping("/sentContact")
	@ResponseBody
	public CommonResponseType sendContact(Map<String,Object>map,String name,String email) {
		try {
			UserDto usergg = new UserDto();
			BeanUtils.copyProperties(JSONObject.parseObject((String) redisUtils.get("currentUser"), UserDto.class), usergg);
			System.out.println(usergg.getLoginId());
			Date date = new Date();
			indexService.saveContact(new ContactDto(name, email, usergg.getUserName(), usergg.getUserName(),date,date));
			map.put("msg", "发送成功");
			return CommonResponseType.create(map);
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
}
