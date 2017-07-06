package org.demo.service;

import org.demo.dao.UserDao;
import org.demo.entity.UserBean;

public class LoginService {
	public boolean checkUser(UserBean user){
		UserDao dao=new UserDao();
		UserBean newUser=dao.findUserByName(user);
		System.out.println(newUser);
		return (newUser!=null&&newUser.getPassword().equals(user.getPassword()));
	}
}
