package com.wyd.cat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.dto.UserDto;
import com.wyd.cat.service.ContactService;
import com.wyd.cat.webutils.error.errornum.EmBusinessError;
import com.wyd.cat.webutils.exception.BusinessException;
import com.wyd.cat.webutils.exception.SystemException;
import com.wyd.cat.webutils.result.CommonResponseType;
import com.wyd.cat.webutils.result.Result;
import com.wyd.cat.webutils.utils.RedisUtils;

import org.springframework.web.bind.annotation.CrossOrigin;

@Controller
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
@RequestMapping("/contact")
public class ContactController {
	@Autowired
	private ContactService contactService;
	
	@Autowired
	private RedisUtils redisUtils;
	
	@Autowired
	private HttpSession session;
	
	private final static String finalName = "游客";
	
	/**
	 * 发送联系人信息
	 * */
	@RequestMapping("/sentContact")
	@ResponseBody
	public CommonResponseType sendContact(Map<String,Object>map,String name,String email, String subject, String message, String phoneNumber) {
		try {
			//从session中取出当前登陆用户
			Date date = new Date();
			UserDto usergg = new UserDto();
			ContactDto contactDto = null;
			String object = (String) session.getAttribute("loginUser");
			//如果用户已经登陆
			if(object != null && !"".equals(object)) {
				BeanUtils.copyProperties(JSONObject.parseObject(object, UserDto.class), usergg);
			} else {
				usergg.setUserName(finalName);
			}
			contactDto = new ContactDto(name, email, phoneNumber, subject, message, usergg.getUserName(), usergg.getUserName(), date, date);
			contactService.saveContact(contactDto);
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
