package com.wyd.cat.dto;

import com.wyd.cat.model.Life;

public class LifeDto extends Life {
	private String imgUrl;

	/** 
	* 获取imgUrl 
	* @return imgUrl
	*/
	public String getImgUrl() {
		return imgUrl;
	}

	/** 
	* 设置imgUrl 
	* @param imgUrl 
	*/
	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}
	
	
}
