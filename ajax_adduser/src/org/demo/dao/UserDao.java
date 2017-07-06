package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.demo.entity.UserBean;
import org.demo.util.DBUtil;



public class UserDao {
	/**
	 * 添加用户的方法
	 * 
	 */
	public int addUser(UserBean user){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into myuser values(?,?,?,?)";
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getName());
			ps.setString(2, user.getPassword());
			ps.setInt(3, user.getAge());
			ps.setString(4, user.getAddress());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null,ps,conn);
		}
		return i;
	}
	
}
