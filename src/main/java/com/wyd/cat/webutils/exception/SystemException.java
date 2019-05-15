package com.wyd.cat.webutils.exception;

public class SystemException extends Exception{
	/**
	 * 序列化id
	 */
	private static final long serialVersionUID = 1L;
	
	// 提供无参数的构造方法
	public SystemException() { 
	} 

	// 提供一个有参数的构造方法，可自动生成
	public SystemException(String message) { 
		// 把参数传递给Throwable的带String参数的构造方法 
		super(message);
	} 
}
