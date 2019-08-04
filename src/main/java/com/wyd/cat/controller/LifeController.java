package com.wyd.cat.controller;


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Date;
import java.util.HashMap;

import java.util.List;
import java.util.Map;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.fastjson.JSONObject;
import com.wyd.cat.dao.CommentRepository;
import com.wyd.cat.dto.ContactDto;
import com.wyd.cat.dto.ImgDto;
import com.wyd.cat.dto.LifeDto;
import com.wyd.cat.dto.LifeTypeDto;
import com.wyd.cat.dto.LifeUpdateDto;
import com.wyd.cat.dto.UserDto;
import com.wyd.cat.model.Comment;
import com.wyd.cat.model.Life;
import com.wyd.cat.service.ImgService;
import com.wyd.cat.service.LifeService;
import com.wyd.cat.service.LifeUpdateService;
import com.wyd.cat.service.TypeService;
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
	private LifeUpdateService lifeUpdateService;
	@Autowired
	private TypeService typeService;
	
	@Autowired
	private ImgService imgService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private HttpSession session;
	
	private final static String finalName = "游客";
	private final static String loginid = "conmonUser";
	private final static String defaultLifeUpdate = "这篇文章被创建了";
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
			usergg.setLoginId(loginid);
		}
		
		String fileName = file.getOriginalFilename();
		//设置上传的路径
		String realPath = httpServletRequest.getServletContext().getRealPath(File.separator) + "\\uploadFile";
		System.out.println(realPath);
        //相对路径
		String imgPath =  "/uploadFile";
		if (file != null && !file.isEmpty()) {
        	
			try {
				//保存上传的文件
				InputStream in= file.getInputStream();//声明输入输出流
	            
	            OutputStream out=new FileOutputStream(new File(realPath+"\\"+fileName));//指定输出流的位置;
	            
	            byte []buffer =new byte[1024];
	            int len=0;
	            while((len=in.read(buffer))!=-1){
	                out.write(buffer, 0, len);
	                out.flush();                //类似于文件复制，将文件存储到输入流，再通过输出流写入到上传位置
	            } //这段代码也可以用IOUtils.copy(in, out)工具类的copy方法完成
	            
	            out.close();
	            in.close();
	            
	            //保存图片信息
	            String imgId = "life_" + new Date().getTime();
	            imgService.save(new ImgDto(imgId,imgPath + "/" + fileName,fileName));     
	            
	            //保存生活信息
	            life.setImgId(imgId);
	            life.setAuthor(usergg.getLoginId());
	            life.setCreateAt(date);
	            life.setCreateBy(usergg.getLoginId());
	            life.setUpdateAt(date);
	            life.setUpdateBy(usergg.getLoginId());
	            life.setIsDelete("f");
	            lifeService.save(life);
	            
	            //保存更新日历信息
	            LifeUpdateDto lifeUpdateDto = new LifeUpdateDto();
	            lifeUpdateDto.setLifeId(life.getId());
	            lifeUpdateDto.setUpdateTime(date);
	            lifeUpdateDto.setUpdateTitle(defaultLifeUpdate);
	            lifeUpdateDto.setUserId(usergg.getLoginId());
	            lifeUpdateDto.setUserName(usergg.getUserName());
	            lifeUpdateService.putOneLifeUpdate(lifeUpdateDto);
	            
	            //保存标签信息
	            String [] types =  type.split("&");
	            for (String typ : types) {
	            	LifeTypeDto lifeTypeDto = new LifeTypeDto();
		            lifeTypeDto.setLifeId(life.getId());
		            lifeTypeDto.setTypeId(typ);
		            lifeTypeDto.setTypeName(type);
		            lifeTypeDto.setCreateAt(date);
		            lifeTypeDto.setCreateBy(usergg.getLoginId());
		            lifeTypeDto.setUpdateAt(date);
		            lifeTypeDto.setUpdateBy(usergg.getLoginId());
		            lifeTypeDto.setIsDelete("f");
		            typeService.insertOneLifeType(lifeTypeDto);
				}
	            
			} catch (IOException e) {
				Map<String,Object> errorMap = new HashMap<>();
				errorMap.put("errorMsg", EmBusinessError.FILE_DIC_NOT_EXCIT.getErrorMsg());
				errorMap.put("errorCode", EmBusinessError.FILE_DIC_NOT_EXCIT.getErrorCode());
				return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
			} catch (BusinessException e1) {
				Map<String,Object> errorMap = new HashMap<>();
				errorMap.put("errorMsg", EmBusinessError.LIFE_NOT_ERROR.getErrorMsg());
				errorMap.put("errorCode", EmBusinessError.LIFE_NOT_ERROR.getErrorCode());
				return CommonResponseType.create(errorMap,Result.FAIL.getStauts());
			}
            
        }
        return CommonResponseType.create("保存成功", Result.SUCCESS.getStauts());
 
    }
	
	/***
	 * springdata jpa 
	 */
	@Autowired
	private CommentRepository commentRepository;
	
	@RequestMapping("/putComment")
	@ResponseBody
	public CommonResponseType putComment(String message, Integer lifeId) {
		
		//从session中取出当前登陆用户
		Date date = new Date();
		UserDto usergg = new UserDto();
		String object = (String) session.getAttribute("loginUser");
		//如果用户已经登陆
		if(object != null && !"".equals(object)) {
			BeanUtils.copyProperties(JSONObject.parseObject(object, UserDto.class), usergg);
		} else {
			usergg.setUserName(finalName);
			usergg.setLoginId(loginid);
		}
		
		Comment comment = new Comment();
		//生活id
		comment.setLifeId(lifeId);
		//设置更新用户
		comment.setUserId(usergg.getLoginId());
		//设置评论内容
		comment.setContext(message);
		//点赞次数
		comment.setReplycount("1");
		//创建日期
		comment.setCreateAt(date);
		//创建者
		comment.setCreateBy(usergg.getUserName());
		//更新日期
		comment.setUpdateAt(date);
		//更新者
		comment.setUpdateBy(usergg.getUserName());
		//是否是最精评论
		comment.setIsBetter("f");
		//是否删除
		comment.setIsDelete("f");
		comment.setTime(date);
		commentRepository.save(comment);
		return CommonResponseType.create("保存成功", Result.SUCCESS.getStauts());
	}

}
