package org.order.service;

import org.order.bean.UserBean;
import org.order.dao.UserDao;

public class LoginService {
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
