package com.wyd.cat.webutils.error.errornum;

import com.wyd.cat.webutils.error.CommonError;

/**错误消息枚举*/
public enum EmBusinessError implements CommonError {
	/**系统未知错误* */
	UNKNOW_ERROR(10001,"未知错误"),	
	/**客户端参数错误* */
	PARAMETER_VALIDATION_ERROR(20001,"参数类型错误"),
	OTP_IS_ERROR(20002,"验证码错误"),
	/**系统错误*/
	USER_NOT_EXCIT(30001,"用户不存在"),
	SENT_CONTACT_ERROR(30002,"发生了错误了，请联系管理员"),
	LIFE_NOT_EXCIT(40001,"生活数据不存在")
	
	
	
	;

	private int errorCode;
	private String errorMsg;
	
	private EmBusinessError(int errorCode, String errorMsg) {
		this.errorCode = errorCode;
		this.errorMsg = errorMsg;
	}
	
	
	
	@Override
	public int getErrorCode() {
		return this.errorCode;
	}

	@Override
	public String getErrorMsg() {
		return this.errorMsg;
	}

	@Override
	public CommonError setErrorMsg(String msg) {
		this.errorMsg = msg; 
		return this;
	}

}
