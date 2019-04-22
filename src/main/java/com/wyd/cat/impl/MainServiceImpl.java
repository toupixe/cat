package com.wyd.cat.impl;

import java.util.Date;


import org.springframework.stereotype.Service;


import com.wyd.cat.model.Contact;
import com.wyd.cat.model.User;
import com.wyd.cat.service.MainService;
import com.wyd.cat.utils.UserUtils;

@Service
public class MainServiceImpl implements MainService{

	@Override
	public void addConnection(Contact con) {
		/**取得当前用户*/
		User user = UserUtils.getCurrentUser();
		Date date  = new Date();
		con.setCreateAt(date);
		con.setCreateBy(user.getUserName());
		con.setUpdateAt(date);
		con.setUpdateBy(user.getUserName());
		con.setIsDeleted("f");
	
	}

}
