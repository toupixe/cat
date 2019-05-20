package com.wyd.cat.dto;

import com.wyd.cat.model.Comment;

public class CommentDto extends Comment{
	private String userName;

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
