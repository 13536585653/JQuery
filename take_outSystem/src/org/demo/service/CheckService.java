package org.demo.service;

import org.demo.dao.UserDao;
import org.demo.entity.UserBean;

public class CheckService {
	public UserBean checkUser(UserBean user){
		//�ж��û��Ƿ����
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
