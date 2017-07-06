package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.demo.entity.Users;
import org.demo.utils.DBUtil;
import org.junit.Test;

public class UserDao {
	/**
	 * �����û�����ѯ�û�
	 */
	public Users findUserByName(String userName){
		Users user=new Users();
		String sql="select * from users where u_name=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, userName);
			rs=ps.executeQuery();
			if(rs.next()){
				user.setUid(rs.getInt(1));
				user.setUserName(rs.getString(2));
				user.setPassword(rs.getString(3));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return user;
	}
	//���Բ�ѯ�û�
	@Test
	public void main() {
		UserDao dao=new UserDao();
		Users name=dao.findUserByName("��Ұ");
		System.out.println(name);
	}
}
