package com.wyd.cat.dto;

import java.util.Date;

import com.wyd.cat.model.Contact;

public class ContactDto extends Contact{
	
	public ContactDto() {
		
	}
	/**
	 * 简单联系时，构造简单的联系人
	 * */
	public ContactDto(String name, String phoneNumber, String createby, String updateBy, Date createAt, Date updateAt) {
		this.setName(name);
		this.setPhoneNumber(phoneNumber);
		this.setCreateBy(createby);
		this.setUpdateBy(updateBy);
		this.setUpdateAt(updateAt);
		this.setCreateAt(createAt);
		
	}
	
	/**构建完整的联系人*/
	public ContactDto(String name, String email, String phoneNumber, String subject, String message, String createby, String updateBy, Date createAt, Date updateAt) {
		this.setName(name);
		this.setEmail(email);
		this.setPhoneNumber(phoneNumber);
		this.setSubject(subject);
		this.setMessage(message);
		this.setCreateBy(createby);
		this.setUpdateBy(updateBy);
		this.setUpdateAt(updateAt);
		this.setCreateAt(createAt);
		
	}
		
}
