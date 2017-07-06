package org.demo.service;

import org.demo.dao.UserDao;
import org.demo.entity.UsersBean;

public class RegService {
	public boolean addUser(UsersBean user){
		UserDao dao=new UserDao();
		boolean users=dao.addUser(user);
		if(users!=false){
			//.´ýÐø
		}
		return true;
	}
}
