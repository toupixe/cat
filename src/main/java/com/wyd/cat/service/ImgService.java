package com.wyd.cat.service;

import com.wyd.cat.dto.ImgDto;
import com.wyd.cat.webutils.exception.BusinessException;

public interface ImgService {
	/**
	 * 保存一张图片
	 * @param imgDto
	 * @throws BusinessException
	 */
	public void save(ImgDto imgDto)throws BusinessException;;
}
