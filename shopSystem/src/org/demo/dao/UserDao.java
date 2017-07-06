package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.demo.entity.UserBean;
import org.demo.utils.DBUtil;

public class UserDao {
	/**
	 * 查询个用户的方法
	 */
	public UserBean findUserByName(UserBean user){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from users where u_name=?";
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUserName());
			rs=ps.executeQuery();
			if(rs.next()){
				UserBean newUser=new UserBean();
				newUser.setUid(rs.getInt(1));
				newUser.setUserName(rs.getString(2));
				newUser.setPassword(rs.getString(3));
				return newUser;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return null;
	}
}
