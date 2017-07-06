package org.demo.service;

import org.demo.dao.UserDao;
import org.demo.entity.UserBean;

public class CheckService {
	public UserBean checkUser(UserBean user){
		//判断用户是否存在
		UserDao dao=new UserDao();
		UserBean newUser=dao.findUserByName(user);
		if(newUser!=null){
			if(user.getUpwd().equals(newUser.getUpwd())){
				return user;
			}
		}
		 	return null;
	}
}
