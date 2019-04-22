package com.wyd.cat.dto;

import java.util.Date;

import com.wyd.cat.model.Contact;

public class ContactDto extends Contact{
	
	public ContactDto() {
		
	}
	public ContactDto(String name, String email, String createby, String updateBy, Date createAt, Date updateAt) {
		this.setName(name);
		this.setEmail(email);
		this.setCreateBy(createby);
		this.setUpdateBy(updateBy);
		this.setUpdateAt(updateAt);
		this.setCreateAt(createAt);
		
	}
		
}
