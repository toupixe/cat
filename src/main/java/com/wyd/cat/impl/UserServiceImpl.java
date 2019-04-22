package com.wyd.cat.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wyd.cat.dao.UserMapper;
import com.wyd.cat.dto.UserDto;
import com.wyd.cat.model.User;
import com.wyd.cat.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;
	
	@Override
	public UserDto getUserByUserId(String userId) {
		User user =  userMapper.getUserByUserId(userId);		
		return convartModelToDto(user);
	}

	private UserDto convartModelToDto(User user) {
		
		UserDto userDto = new UserDto();
		if (user == null) {
			return null;
		}
		BeanUtils.copyProperties(user, userDto);
		
		return userDto;
		
	}
}
