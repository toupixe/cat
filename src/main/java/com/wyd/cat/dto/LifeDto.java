package com.wyd.cat.dto;


import java.util.List;

import com.wyd.cat.model.Life;


public class LifeDto extends Life {
	private String imgUrl;
	
	/**
	 * 生活标签
	 */
	private List<LifeTypeDto> lifeTypeLst;
	
	/**
	 * 生活更新状态
	 */
	private List<LifeUpdateDto> lifeUpdateLst;
	
	/**
	 * 生活评论
	 */
	private List<CommentDto> commentLst;
	
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

	/** 
	* 获取lifeTypeLst 
	* @return lifeTypeLst
	*/
	public List<LifeTypeDto> getLifeTypeLst() {
		return lifeTypeLst;
	}

	/** 
	* 设置lifeTypeLst 
	* @param lifeTypeLst 
	*/
	public void setLifeTypeLst(List<LifeTypeDto> lifeTypeLst) {
		this.lifeTypeLst = lifeTypeLst;
	}

	/** 
	* 获取lifeUpdateLst 
	* @return lifeUpdateLst
	*/
	public List<LifeUpdateDto> getLifeUpdateLst() {
		return lifeUpdateLst;
	}

	/** 
	* 设置lifeUpdateLst 
	* @param lifeUpdateLst 
	*/
	public void setLifeUpdateLst(List<LifeUpdateDto> lifeUpdateLst) {
		this.lifeUpdateLst = lifeUpdateLst;
	}

	/** 
	* 获取commentLst 
	* @return commentLst
	*/
	public List<CommentDto> getCommentLst() {
		return commentLst;
	}

	/** 
	* 设置commentLst 
	* @param commentLst 
	*/
	public void setCommentLst(List<CommentDto> commentLst) {
		this.commentLst = commentLst;
	}

	
	
}
