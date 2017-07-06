package org.demo.service;
import org.demo.dao.UserDao;
import org.demo.entity.UsersBean;

public class LoginService {
	public boolean findUser(String userName,String userPwd){
		UserDao dao=new UserDao();
		UsersBean user=dao.findUserByName(userName);
		System.out.println(user);
		return userName!=null&&userPwd.equals(user.getUpassword());
			}
			
	}

