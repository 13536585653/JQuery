package com.ms.msspace.user.service.daoimpl;

import java.util.HashMap;
import java.util.Map;

import com.ms.msspace.factory.MsspaceFactory;
import com.ms.msspace.user.dao.UserDao;
import com.ms.msspace.user.entity.Users;
import com.ms.msspace.user.service.dao.UserServiceDao;

public class UserServiceDaoImpl implements UserServiceDao {
	private UserDao dao = MsspaceFactory.getUserImpl();
	@Override
	public int login(String name, String password) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int register(Users user) {
		/**
		 * map集合用于保存错误信息
		 */
		 Map<String,String> map = new HashMap<String,String>();
		
		
		String username = user.getUsername();
		if(username==null || username.trim().isEmpty()){
			map.put("username", "昵称不能为空");
		}else if(!(username.length()>=4 && username.length()<=16)){
			map.put("username", "昵称长度应在4到16字符之间");
		}
		
		//调用dao
		dao.register(user) ;
		
		return 0;
	}

	@Override
	public Users selectUsersById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int isExistUser(String name) {
		return dao.isExistUser(name);

	}
	
}
