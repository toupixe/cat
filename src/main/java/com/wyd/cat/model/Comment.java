package com.wyd.cat.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tb_comment")
public class Comment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer lifeId;
	private String userId;
	private Date time;
	private String context;
	private String replycount;
	private Date createAt;
	private String createBy;
	private Date updateAt;
	private String updateBy;
	private String isDelete;
	private String isBetter;
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
	* 获取time 
	* @return time
	*/
	public Date getTime() {
		return time;
	}
	/** 
	* 设置time 
	* @param time 
	*/
	public void setTime(Date time) {
		this.time = time;
	}
	/** 
	* 获取context 
	* @return context
	*/
	public String getContext() {
		return context;
	}
	/** 
	* 设置context 
	* @param context 
	*/
	public void setContext(String context) {
		this.context = context;
	}
	/** 
	* 获取replycount 
	* @return replycount
	*/
	public String getReplycount() {
		return replycount;
	}
	/** 
	* 设置replycount 
	* @param replycount 
	*/
	public void setReplycount(String replycount) {
		this.replycount = replycount;
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
	/** 
	* 获取isBetter 
	* @return isBetter
	*/
	public String getIsBetter() {
		return isBetter;
	}
	/** 
	* 设置isBetter 
	* @param isBetter 
	*/
	public void setIsBetter(String isBetter) {
		this.isBetter = isBetter;
	}
	
	
}
