package com.wyd.cat.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
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

		try {
			lifeService.save(life);
		} catch (BusinessException e1) {
			Map<String,Object> errorMap = new HashMap<>();
			errorMap.put("errorMsg", EmBusinessError.LIFE_NOT_ERROR.getErrorMsg());
			errorMap.put("errorCode", EmBusinessError.LIFE_NOT_ERROR.getErrorCode());
			return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
		}
		
		String fileName = file.getOriginalFilename();
		//设置上传的路径
		String realPath = httpServletRequest.getServletContext().getRealPath(File.separator) + "\\uploadFile";
		System.out.println(realPath);
        if (file != null && !file.isEmpty()) {
        	
			try {
				
				InputStream in= file.getInputStream();//声明输入输出流
	            
	            OutputStream out=new FileOutputStream(new File(realPath+"\\"+fileName));//指定输出流的位置;
	            
	            byte []buffer =new byte[1024];
	            int len=0;
	            while((len=in.read(buffer))!=-1){
	                out.write(buffer, 0, len);
	                out.flush();                //类似于文件复制，将文件存储到输入流，再通过输出流写入到上传位置
	            }                               //这段代码也可以用IOUtils.copy(in, out)工具类的copy方法完成
	                                            
	            out.close();
	            in.close();
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
