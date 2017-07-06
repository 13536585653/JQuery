package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.demo.entity.LoveBean;
import org.demo.utils.DBUtil;

public class LoveDao {
	/**
	 * 添加爱心捐款的方法
	 * @param love
	 * @return
	 */
	public int addLove(LoveBean love){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into LoveInHeart values(?,?,?,?)";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1,love.getLname() );
			ps.setString(2, love.getLsex());
			ps.setDate(3, love.getLtime());
			ps.setDouble(4, love.getLmoney());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return i;
	}
	
	/**
	 * 查询全部爱心的方法
	 * @return
	 */
	public List<Map<String,Object>> findLove(){
		ResultSet rs=null;
		Connection conn=null;
		PreparedStatement ps=null;
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		String sql="select * from LoveInHeart order by lid desc";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("lid", rs.getInt(1));
				map.put("lname", rs.getString(2));
				map.put("lsex", rs.getString(3));
				map.put("ltime", rs.getDate(4));
				map.put("lmoney", rs.getDouble(5));
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
