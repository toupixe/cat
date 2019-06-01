package com.wyd.cat.controller;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import java.util.List;
import java.util.Map;



import javax.servlet.ServletException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.wyd.cat.dto.LifeDto;
import com.wyd.cat.model.Life;
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
	
	@Autowired
	private HttpServletRequest httpServletRequest;
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
	
	@RequestMapping("/uploadLifePic")
	@ResponseBody
	public CommonResponseType uploadLifePic(Life life ,MultipartFile file,String cate, String type) {

		String fileName = file.getOriginalFilename();
		//设置上传的路径
		String realPath = httpServletRequest.getServletContext().getRealPath(File.separator) + "\\uploadFile\\" + fileName;
		System.out.println(realPath);
        if (file != null && !file.isEmpty()) {
        	byte[] bytes;
			try {
				bytes = file.getBytes();
				Path path = Paths.get(realPath);
	            Files.write(path, bytes);
			} catch (IOException e) {
				Map<String,Object> errorMap = new HashMap<>();
				errorMap.put("errorMsg", EmBusinessError.FILE_DIC_NOT_EXCIT.getErrorMsg());
				errorMap.put("errorCode", EmBusinessError.FILE_DIC_NOT_EXCIT.getErrorCode());
				return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
			}
            
        }
        	//保存文件
           // saveUploadedFiles(Arrays.asList(uploadfile));
 
        return CommonResponseType.create("保存成功", Result.SUCCESS.getStauts());
 
    }

}
