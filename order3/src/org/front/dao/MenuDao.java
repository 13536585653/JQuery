package org.front.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.order.bean.Menu;
import org.order.utils.DBConnection;

public class MenuDao {

	
	/**
	 * 
	 * 查询所有菜单的条数
	 * @return
	 */
	public int count() {
		String sql="select count(b.m_id) as bcount from menu b left join dishes t on b.m_id=t.d_id ";
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int rowCount=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, ps, conn);
		}
		return rowCount;
	}

	
	//查询所有菜单的分页
	public List<Map<String, Object>> findBookList(int firstResult, int maxResult) {
		String sql="SELECT m.m_id,m.jx,m.m_name,m.m_price,m.m_image ,m.d_id,m_description ,s.d_type from  menu m left join dishes s on  m.d_id=s.d_id  ORDER BY m.m_time DESC LIMIT ?,?";

	    PreparedStatement pstm=null;
	    Connection conn=null;
	    ResultSet rs=null;
	    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	    try {
	    	conn=DBConnection.getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, firstResult);
			pstm.setInt(2, maxResult);
			rs=pstm.executeQuery();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("id", rs.getInt(1));
				map.put("m_name", rs.getString(3));
				map.put("m_image", rs.getString(5));
				map.put("price", rs.getString(4));
				map.put("tecont", rs.getString(7));
				map.put("d_type", rs.getString(8));			
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, pstm, conn);
		}
		return list;
	}


	public List<Menu> selectjxmenu() {
		
		String sql="select * from menu where jx=1 LIMIT 8 OFFSET  0";

	    PreparedStatement pstm=null;
	    Connection conn=DBConnection.getConnection();
	    ResultSet rs=null;
	    List<Menu> list=new ArrayList<Menu>();
	    try {
	    	pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Menu m=new Menu();
				m.setM_id(rs.getInt(1));
				m.setM_name(rs.getString(2));
				m.setM_img(rs.getString(4));
				m.setM_description(rs.getString(5));
				m.setM_price(rs.getFloat(3));	
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, pstm, conn);
		}
		return list;
	}

	
	/**
	 * 
	 * 查询所有菜
	 * @return
	 */

	public List<Menu> selectMenuAll() {
		String sql="select * from menu  LIMIT 8 OFFSET  0";

	    PreparedStatement pstm=null;
	    Connection conn=DBConnection.getConnection();
	    ResultSet rs=null;
	    List<Menu> list=new ArrayList<Menu>();
	    try {
	    	pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Menu m=new Menu();
				m.setM_id(rs.getInt(1));
				m.setM_name(rs.getString(2));
				m.setM_img(rs.getString(4));
				m.setM_description(rs.getString(5));
				m.setM_price(rs.getFloat(3));	
				list.add(m);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, pstm, conn);
		}
		return list;
	}

}
