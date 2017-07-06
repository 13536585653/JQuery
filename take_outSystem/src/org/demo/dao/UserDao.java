package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.demo.entity.RoleBean;
import org.demo.entity.UserBean;
import org.demo.util.DBUtil;

public class UserDao {
	/**
	 * 添加用户的方法
	 * @param user
	 * @return
	 */
	public int addUser(UserBean user){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into users values(?,?,?,?,?,?,?,?)";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setString(3, user.getUsex());
			ps.setString(4, user.getUaddr());
			ps.setString(5, user.getUemail());
			ps.setString(6, user.getUtel());
			ps.setFloat(7, user.getUmonetary());
			ps.setInt(8, user.getRtype().getRid());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return i;
	}
	
	/**
	 * 批量删除的方法
	 * @param usersid
	 * @return
	 */
	public int[] removeUsers(int[] usersid){
		Connection conn=null;
		PreparedStatement ps=null;
		int[] rows=null;
		String sql="delete from users where u_id=?";
		
		try{
			conn=DBUtil.getConnection();
			//通过连接，设置conn自动提交为手动提交
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			for (int uid : usersid) {
				ps.setInt(1, uid);
				//添加到批量操作的缓存中
				ps.addBatch();
			}
			//执行批量操作
			rows=ps.executeBatch();
			//手动提交事务
			conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
			//进行事务回滚操作
			try{
				conn.rollback();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return rows;
	}
	
	/**
	 * 查询某个用户的方法
	 * @param user
	 * @return
	 */
	public UserBean findUserByName(UserBean user){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from users where u_name=?";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			rs=ps.executeQuery();
			if(rs.next()){
				UserBean newUser=new UserBean();
				//newUser.setUid(rs.getInt(1));
				newUser.setUname(rs.getString(2));
				newUser.setUpwd(rs.getString(3));
				newUser.setUsex(rs.getString(4));
				newUser.setUaddr(rs.getString(5));
				newUser.setUaddr(rs.getString(6));
				newUser.setUemail(rs.getString(7));
				newUser.setUmonetary(rs.getFloat(8));
				RoleBean role=new RoleBean();
				role.setRtype(rs.getString(9));
				newUser.setRtype(role);
				return newUser;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return null;
	}
	
	/**
	 * 查询全部用户的方法
	 * @return
	 */
	public List<UserBean> findUsers(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<UserBean> list=new ArrayList<UserBean>();
		String sql="select * from users";
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				UserBean user=new UserBean();
				//user.setUid(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setUpwd(rs.getString(3));
				user.setUsex(rs.getString(4));
				user.setUaddr(rs.getString(5));
				user.setUaddr(rs.getString(6));
				user.setUemail(rs.getString(7));
				user.setUmonetary(rs.getFloat(8));
				RoleBean role=new RoleBean();
				role.setRtype(rs.getString(9));
				user.setRtype(role);
				list.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
			return list;
	}
	/***
	 * 修改用户信息的方法
	 * @param user
	 * @return
	 */
	public int UpdateUser(UserBean user){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		//可以更新密码、地址、email、和电话。
		String sql="Update users set u_pwd=?,u_addr=?,u_email=?,u_tel=? where u_id=?";
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			//ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			//ps.setString(3, user.getUsex());
			ps.setString(4, user.getUaddr());
			ps.setString(5, user.getUemail());
			ps.setString(6, user.getUtel());
			//ps.setString(7, user.getRtype().getRtype());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return i;
		
	}
}
