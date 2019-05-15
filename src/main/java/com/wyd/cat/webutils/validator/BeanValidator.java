package com.wyd.cat.webutils.validator;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;



/**javaBean的验证器*/
public class BeanValidator {
	/**是否有错*/
	private boolean hasError = false;
	/**验证消息map*/
	private Map<String,Object> errorMsgMap = new HashMap<>();
	
	/**
	 * 获取验证报错的msg
	 * */
	public String getErrorMsg() {
		return StringUtils.join(errorMsgMap.values().toArray(),",");
		
	}
	
	/**
	 * @return the hasError
	 */
	public boolean isHasError() {
		return hasError;
	}
	/**
	 * @param hasError the hasError to set
	 */
	public void setHasError(boolean hasError) {
		this.hasError = hasError;
	}
	/**
	 * @return the errorMsgMap
	 */
	public Map<String, Object> getErrorMsgMap() {
		return errorMsgMap;
	}
	/**
	 * @param errorMsgMap the errorMsgMap to set
	 */
	public void setErrorMsgMap(Map<String, Object> errorMsgMap) {
		this.errorMsgMap = errorMsgMap;
	}
	
	
}
