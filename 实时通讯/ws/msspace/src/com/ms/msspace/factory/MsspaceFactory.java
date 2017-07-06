package com.ms.msspace.factory;

import com.ms.msspace.user.dao.UserDao;
import com.ms.msspace.user.daoimpl.UserImpl;
import com.ms.msspace.user.service.dao.UserServiceDao;
import com.ms.msspace.user.service.daoimpl.UserServiceDaoImpl;

public class MsspaceFactory {
	/**
	 * 用户dao工厂
	 * @return
	 */
	public static UserDao getUserImpl(){
		return new UserImpl() ;
	}
	
	public static UserServiceDao getUserServiceDaoImpl(){
		return new UserServiceDaoImpl() ;
	}
}
