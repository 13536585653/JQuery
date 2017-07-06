package org.demo.service;

import org.demo.dao.UserDao;
import org.demo.entity.Users;

public class LoginService {
	/***
	 * 校验用户的账号是否正确
	 */
	public boolean checkUser(String userName,String password){
		UserDao dao = new UserDao();
		Users user = dao.findUserByName(userName);
		System.out.println(user);
		//如果查询的用户不为空，那么就验证密码是否一致
		//简练代码，使用三目运算符进行验证
		return (user!=null&&password.equals(user.getPassword()));
		}
		/*if(user!=null){
			if(password.equals(user.getPassword())){
				return true;
				}
			}
		//如果用户为空，或者密码不一致都返回false
		return false;
	}*/
}
