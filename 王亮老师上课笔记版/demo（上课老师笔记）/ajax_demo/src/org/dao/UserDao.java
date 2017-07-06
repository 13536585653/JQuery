package org.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.entity.UserBean;
import org.utils.DBUtil;

public class UserDao {

	public List<UserBean> findUsers(){
		String sql = "select * from users_info";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		List<UserBean> list = new ArrayList<UserBean>();
		try{
			conn = DBUtil.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				UserBean  u = new UserBean();
				u.setId(rs.getInt(1));
				u.setUserName(rs.getString(2));
				u.setAge(rs.getInt(4));
				u.setAddr(rs.getString(5));
				list.add(u);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}
}
