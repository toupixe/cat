package com.wyd.cat.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.errorenum.EmBusinessError;
import com.wyd.cat.exception.BusinessException;
import com.wyd.cat.exception.SystemException;
import com.wyd.cat.model.User;
import com.wyd.cat.result.CommonResponseType;
import com.wyd.cat.result.Result;
import com.wyd.cat.service.IndexService;
import com.wyd.cat.utils.UserUtils;

@Controller
@RequestMapping("/index")
public class IndexController extends BaseController{
	
	@Autowired
	private IndexService indexService;
	
	/**
	 * 发送联系人信息
	 * */
	@RequestMapping("/sentContact")
	@ResponseBody
	public CommonResponseType sendContact(Map<String,Object>map,String name,String email) {
		try {
			User user = UserUtils.getCurrentUser();
			Date date = new Date();
			indexService.saveContact(new ContactDto(name, email, user.getUserName(), user.getUserName(),date,date));
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
