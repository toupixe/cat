package com.wyd.cat.dto;

import com.wyd.cat.model.LifeType;

public class LifeTypeDto extends LifeType{
	private String typeName;

	/** 
	* 获取typeName 
	* @return typeName
	*/
	public String getTypeName() {
		return typeName;
	}

	/** 
	* 设置typeName 
	* @param typeName 
	*/
	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}
	
	

}
