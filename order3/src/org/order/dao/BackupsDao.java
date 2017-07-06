package org.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.order.bean.Backups;
import org.order.utils.DBConnection;



public class BackupsDao {

	/*public List<Backups> select() {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		List<Backups> list=new ArrayList<Backups>();
		ResultSet rs=null;
		String sql="select * from  backups ";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Backups b=new Backups();
				b.setB_id(rs.getInt(1));
				b.setB_name(rs.getString(2));
				b.setB_time(rs.getTimestamp(3));
				list.add(b);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}*/

	
	
	public int insert(String str) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="insert into backups values(null,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, str);
			ps.setTimestamp(2, new Timestamp(new Date().getTime()));
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;

	}



	public int delete(String name) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="delete from backups where b_name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, name);
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;

	}



	
	/**
	 * 
	 * 
	 * 统计条数
	 * @return
	 */
	public int count() {
		String sql="select count(b_id) as bcount from backups";
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



	/**
	 * 
	 * 分页查询
	 * @param firstResult
	 * @param i
	 * @return
	 */
	public List<Map<String, Object>> selectbackups(int firstResult, int maxResult) {
		String sql="SELECT  * from  backups  ORDER BY b_time DESC LIMIT ?,? ";	
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
				//姣忓惊鐜竴娆″垱寤轰竴涓猰ap瀵硅薄锛屼竴涓猰ap瀵瑰簲涓�潯璁板綍
				Map<String ,Object> map=new HashMap<String ,Object>();
				map.put("b_id", rs.getInt(1));
				map.put("b_name", rs.getString(2));
				map.put("b_time", rs.getTimestamp(3));
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, pstm, conn);
		}
		return list;
	}

}
