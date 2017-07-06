package org.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import org.order.bean.Store;
import org.order.utils.DBConnection;

public class StroeDao {

	
	/**
	 * 
	 * 查询店铺信息
	 * @return
	 */
	public Map<String, Object> selectStore() {
		Map<String ,Object> map=new HashMap<String ,Object>();
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from  store";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				map.put("s_name", rs.getString(1));
				map.put("s_tel", rs.getString(2));
				map.put("s_addr", rs.getString(3));
				map.put("s_email", rs.getString(4));
				map.put("s_business", rs.getString(5));
				map.put("s_unit", rs.getString(6));
				map.put("s_way", rs.getInt(7));
				map.put("s_wux", rs.getInt(8));
				map.put("s_state", rs.getInt(9));
				map.put("s_img", rs.getString(10));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return map;
	}

	public int update(Store s) {
		String sql="update store set s_name=?,s_tel=?,s_addr=?,s_email=?,s_business=?,s_unit=?,s_way=?,s_wux=?,s_state=? ,s_img=?";
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, s.getS_name());
			ps.setString(2, s.getS_tel());
			ps.setString(3, s.getS_addr());
			ps.setString(4, s.getS_email());
			ps.setString(5, s.getS_business());
			ps.setString(6, s.getS_unit());
			ps.setInt(7, s.getS_way());
			ps.setInt(8, s.getS_wux());
			ps.setInt(9, s.getS_state());
			ps.setString(10, s.getS_img());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}

	public int Update2(Store s) {
		String sql="update store set s_name=?,s_tel=?,s_addr=?,s_email=?,s_business=?,s_unit=?,s_way=?,s_wux=?,s_state=? ";
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, s.getS_name());
			ps.setString(2, s.getS_tel());
			ps.setString(3, s.getS_addr());
			ps.setString(4, s.getS_email());
			ps.setString(5, s.getS_business());
			ps.setString(6, s.getS_unit());
			ps.setInt(7, s.getS_way());
			ps.setInt(8, s.getS_wux());
			ps.setInt(9, s.getS_state());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}

}
