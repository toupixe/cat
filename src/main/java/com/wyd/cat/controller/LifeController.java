package com.wyd.cat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyd.cat.webutils.result.CommonResponseType;

/**
 * 
* @Description:  关于生活控制器
* @author 王
* @date 2019年4月9日
 */
@Controller
@RequestMapping("/life")
public class LifeController extends BaseController{
	
	/**
	 * 
	 * <p>Title: getLifeLst</p>  
	 * <p>Description: 获取关于生活的列表信息</p>  
	 * @return CommonResponseType 封装返回信息的类
	 */
	@RequestMapping("/life/getLifeLst")
	@ResponseBody
	public CommonResponseType getLifeLst() {
		
		return null;
	}
}
