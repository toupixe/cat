package com.wyd.cat.model;

import java.util.Date;

/**
 * 
* @Description:  生活标签类
* @author 王
* @date 2019年5月16日
 */
public class LifeType {
	private Integer id;
	private Integer lifeId;
	private String typeId;
	private Date createAt;
	private String createBy;
	private Date updateAt;
	private String updateBy;
	private String isDelete;
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
	* 获取typeId 
	* @return typeId
	*/
	public String getTypeId() {
		return typeId;
	}
	/** 
	* 设置typeId 
	* @param typeId 
	*/
	public void setTypeId(String typeId) {
		this.typeId = typeId;
	}
	/** 
	* 获取createAt 
	* @return createAt
	*/
	public Date getCreateAt() {
		return createAt;
	}
	/** 
	* 设置createAt 
	* @param createAt 
	*/
	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}
	/** 
	* 获取createBy 
	* @return createBy
	*/
	public String getCreateBy() {
		return createBy;
	}
	/** 
	* 设置createBy 
	* @param createBy 
	*/
	public void setCreateBy(String createBy) {
		this.createBy = createBy;
	}
	/** 
	* 获取updateAt 
	* @return updateAt
	*/
	public Date getUpdateAt() {
		return updateAt;
	}
	/** 
	* 设置updateAt 
	* @param updateAt 
	*/
	public void setUpdateAt(Date updateAt) {
		this.updateAt = updateAt;
	}
	/** 
	* 获取updateBy 
	* @return updateBy
	*/
	public String getUpdateBy() {
		return updateBy;
	}
	/** 
	* 设置updateBy 
	* @param updateBy 
	*/
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	/** 
	* 获取isDelete 
	* @return isDelete
	*/
	public String getIsDelete() {
		return isDelete;
	}
	/** 
	* 设置isDelete 
	* @param isDelete 
	*/
	public void setIsDelete(String isDelete) {
		this.isDelete = isDelete;
	}
	
	
}
