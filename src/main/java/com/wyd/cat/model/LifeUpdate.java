package com.wyd.cat.model;

import java.util.Date;

/**
 * 
* @Description:  生活更新日历类
* @author 王
* @date 2019年5月16日
 */
public class LifeUpdate {
	private Integer id;
	private Integer lifeId;
	private Date updateTime;
	private String updateTitle;
	/** 
	* 获取id 
	* @return id
	*/
	public Integer getId() {
		return id;
	}
	/** 
	* 设置id 
	* @param id 
	*/
	public void setId(Integer id) {
		this.id = id;
	}
	/** 
	* 获取lifeId 
	* @return lifeId
	*/
	public Integer getLifeId() {
		return lifeId;
	}
	/** 
	* 设置lifeId 
	* @param lifeId 
	*/
	public void setLifeId(Integer lifeId) {
		this.lifeId = lifeId;
	}
	/** 
	* 获取updateTime 
	* @return updateTime
	*/
	public Date getUpdateTime() {
		return updateTime;
	}
	/** 
	* 设置updateTime 
	* @param updateTime 
	*/
	public void setUpdateTime(Date updateTime) {
		this.updateTime = updateTime;
	}
	/** 
	* 获取updateTitle 
	* @return updateTitle
	*/
	public String getUpdateTitle() {
		return updateTitle;
	}
	/** 
	* 设置updateTitle 
	* @param updateTitle 
	*/
	public void setUpdateTitle(String updateTitle) {
		this.updateTitle = updateTitle;
	}
	
	
	
}
