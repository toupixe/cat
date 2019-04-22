package com.wyd.cat.controller;

import java.util.Random;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.wyd.cat.dto.UserDto;
import com.wyd.cat.errorenum.EmBusinessError;
import com.wyd.cat.exception.BusinessException;
import com.wyd.cat.form.UserForm;
import com.wyd.cat.result.CommonResponseType;
import com.wyd.cat.service.UserService;
import com.wyd.cat.validator.BeanValidator;
import com.wyd.cat.validator.ValidatorImplements;

@Controller
@RequestMapping("/user")
@CrossOrigin(allowCredentials="true",allowedHeaders="*")
public class UserController extends BaseController{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private HttpServletRequest httpServletRequest;
	
	@Autowired
	private ValidatorImplements validator;
	
	@RequestMapping("/getUserInfo")
	@ResponseBody
	public CommonResponseType getUserInfo() {	
		UserDto userDto = userService.getUserByUserId("3");
		return CommonResponseType.create(userDto,"success");
	}
	
	@RequestMapping("/getTotp")
	@ResponseBody
	public CommonResponseType getTotp(String phone) {	
		Random random = new Random();
		int randomInt = random.nextInt(99999);
		randomInt += 10000;
		String otp = String.valueOf(randomInt);
		
		httpServletRequest.getSession().setAttribute(phone, otp);
		
		System.out.println(otp);
		
		return CommonResponseType.create(otp,"success");
	}
	
	@RequestMapping("/register")
	@ResponseBody
	public CommonResponseType register(UserForm userForm) throws BusinessException {	
		
		BeanValidator beanValidator = validator.valitador(userForm);
		if (beanValidator.isHasError()) {
			throw new BusinessException(EmBusinessError.PARAMETER_VALIDATION_ERROR,beanValidator.getErrorMsg());
			//return CommonResponseType.create(beanValidator.getErrorMsg(),"failed");
		}
		
		String otp = (String) this.httpServletRequest.getSession().getAttribute(userForm.getPhone());
		if (otp.equals(userForm.getOtp())) {
			return CommonResponseType.create("注册成功","success");
		} else {
			return CommonResponseType.create(EmBusinessError.OTP_IS_ERROR.getErrorMsg(),"failed");
		}
		
	}
}
