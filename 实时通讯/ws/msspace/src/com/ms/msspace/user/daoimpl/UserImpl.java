package com.ms.msspace.user.daoimpl;

import java.sql.Connection;
import java.sql.SQLException;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.ms.msspace.user.dao.UserDao;
import com.ms.msspace.user.entity.Users;
import com.ms.msspace.util.JDBCUtil;

/**
 * 实现用户所操作的功能
 * @author Ms
 *
 */
public class UserImpl implements UserDao {
	// 第一：创建QueryRunner对象
	private QueryRunner qr = new QueryRunner();
	private Connection conn = JDBCUtil.getConnection();

	@Override
	public int login(String name, String password) {
		return 0;
	}

	@Override
	public int register(Users user) {
		return 0;
	}

	@Override
	public Users selectUsersById(int id) {
		return null;
	}
	
	//通过用户名查找该用户是否存在
	@Override
	public int isExistUser(String name) {
		int r = 0 ;
		String sql = "select * form users username=?" ;
		
		try {
			Users user = qr.query(conn, sql, new BeanHandler<Users>(Users.class),name);
			
			if(user!=null){
				r = 1 ;
			}
		} catch (SQLException e) {
			throw new RuntimeException();
		}
		
		return r;
	}

}
