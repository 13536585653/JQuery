package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.demo.entity.UsersBean;
import org.demo.utils.DBUtil;

public class UserDao {
	/**
	 * 添加用户的方法
	 * @param user
	 * @return
	 */
	public boolean addUser(UsersBean user){
		boolean bl=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into users values(?,?,?,?,?,?,?)";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUname() );
			ps.setString(2, user.getUpassword());
			ps.setString(3, user.getUsex());
			ps.setInt(4, user.getUage());
			ps.setString(5, user.getUnum());
			ps.setString(6, user.getUaddress());
			ps.setTimestamp(7, user.getUregTime());
			bl=ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return bl;
	}
	
	/**
	 * 根据uid查询某个用户的方法
	 * @param uid
	 * @return
	 */
	public UsersBean findUserByName(String userName){
		UsersBean user=new UsersBean();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from users where u_name=?";
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			if(rs.next()){
				user.setUname(rs.getString(2));
				user.setUpassword(rs.getString(3));
				return user;
			}
		}catch (SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return user;
	}
}
