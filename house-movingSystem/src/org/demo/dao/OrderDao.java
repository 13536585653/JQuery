package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.demo.entity.HouseBean;
import org.demo.utils.DBUtil;

public class OrderDao {
	/**
	 * 添加预约的方法
	 * @param house
	 * @return
	 */
	public int addOrder(HouseBean house){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into house values(?,?,?,?,?,?)";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, house.getHarea());
			ps.setString(2, house.getHcartype());
			ps.setDate(3, house.getHmovedate());
			ps.setString(4,house.getHcontact());
			ps.setString(5, house.getHphone());
			ps.setByte(6, house.getHstatus());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return i;
	}
	/**
	 * 查询全部的预约
	 * @return
	 */
	public List<Map<String,Object>> findHouse(){
		ResultSet rs=null;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="select * from house order by h_id desc";
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("hid", rs.getInt(1));
				map.put("harea", rs.getString(2));
				map.put("hcartype", rs.getString(3));
				map.put("hmovedate", rs.getDate(4));
				map.put("hcontact", rs.getString(5));
				map.put("hphone", rs.getString(6));
				map.put("hstatus", rs.getByte(7));
				list.add(map);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
		
	}
}
