package com.wyd.cat.dto;

import com.wyd.cat.model.Img;

public class ImgDto extends Img {
	public ImgDto(String imgId,String url, String name) {
		this.setImgId(imgId);
		this.setImgUrl(url);
		this.setImgName(name);
	}
	
	public ImgDto() {
		
	}
}
