package com.wyd.cat.webutils.utils;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;


import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import com.wyd.cat.model.User;
/**
 * 获取当前session的用户
 * */
public class UserUtils {
	
	public static User getCurrentUser() {
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		User user = (User) request.getAttribute("currentUser");
		if (user == null) {
			/**游客*/
			user = new User();
			Date date  = new Date();
			user.setId(2);
			user.setLoginId("commomUser");
			user.setUserName("游客");
			user.setSex("男");
			user.setAge("99");
			user.setCreateAt(date);
			user.setCreateBy("1");
			user.setUpdateAt(date);
			user.setUpdateBy("1");
			user.setIsDeleted("f");
		}
		return user;
	}
}
