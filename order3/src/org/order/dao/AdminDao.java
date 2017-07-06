package org.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.order.bean.Admin;
import org.order.utils.DBConnection;

public class AdminDao {
	/**
	 * ͨ���û�����������
	 * */
	public Admin findAdmin(Admin admin){
		String sql = "select * from adminlogin where a_name = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, admin.getName());
			rs = ps.executeQuery();
			if(rs.next()){
				Admin newadmin= new Admin();
				newadmin.setPwd(rs.getString(3));
				newadmin.setName(rs.getString(2));
				return newadmin;
			}
		}catch(SQLException e){
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, ps, conn);
		}
		return null;
	}

	
	/**
	 * 
	 * 修改密码
	 * @param a
	 * @return
	 */
	public int updatepwd(Admin a) {
		String sql = "update adminlogin set a_pwd =? where a_name=?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, a.getPwd());
			ps.setString(2, a.getName());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}
	
}
