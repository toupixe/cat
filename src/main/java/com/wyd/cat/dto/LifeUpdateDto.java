package com.wyd.cat.dto;

import com.wyd.cat.model.LifeUpdate;

public class LifeUpdateDto extends LifeUpdate{
	private String userId;
	private String userName;
	/** 
	* 获取userId 
	* @return userId
	*/
	public String getUserId() {
		return userId;
	}
	/** 
	* 设置userId 
	* @param userId 
	*/
	public void setUserId(String userId) {
		this.userId = userId;
	}
	/** 
	* 获取userName 
	* @return userName
	*/
	public String getUserName() {
		return userName;
	}
	/** 
	* 设置userName 
	* @param userName 
	*/
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	
}
