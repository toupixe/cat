package com.wyd.cat.service;


import com.wyd.cat.dto.UserDto;


/**用户service*/
public interface UserService {
	/**
	 * 通过用户id获取用户
	 * @param userId 用户id
	 * @return User 用户对象
	 * */
	UserDto getUserByUserId(String userId);
}
