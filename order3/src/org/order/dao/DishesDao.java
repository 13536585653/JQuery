package org.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.order.bean.Dishes;
import org.order.utils.DBConnection;


public class DishesDao {
	/**
	 * 
	 * 查询菜品类型
	 * 
	 * @param d
	 * @return
	 */
	public Dishes finddishes(Dishes d) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;

		String sql = "select * from dishes where d_type=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, d.getD_type());
			rs = ps.executeQuery();
			if (rs.next()) {
				d.setD_type(rs.getString(2));
				return d;
			}
		} catch (SQLException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 
	 * 添加菜品类型
	 * @param d
	 * @return 
	 */
	public int adddisher(Dishes d) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "insert into dishes values(null,?)";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, d.getD_type());
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		}
		return n;
	}

	
	/**
	 * 
	 * 鏌ヨ鎵�湁鑿滃搧鐨勫垎绫�
	 * @return
	 */
	public List<Dishes> selectdishes() {
		List<Dishes> list=new ArrayList<Dishes>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select * from  dishes";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Dishes d=new Dishes();
				d.setD_type(rs.getString(2));
				d.setD_id(rs.getInt(1));
				list.add(d);
			}
		} catch (SQLException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		}
		
		return list;
	}

	
	//批量删除
	public int[] delete(int[] ids) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int [] row=null;
		String sql="delete from dishes where d_id=?";
		try {
			ps=conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			for (int i : ids) {
				ps.setInt(1, i);
				ps.addBatch();
			}
			row=ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
			try{
				conn.rollback();
			}catch(SQLException e1){
				e1.printStackTrace();
			}
		}
		finally {
			DBConnection.close(null, ps, conn);
		}
		return row;
	}

	/**
	 * 
	 * 单个删除
	 * @param id1
	 * @return
	 */
	public int delete1(int id1) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="delete  from dishes where d_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id1);
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		return n;
	}
	
	/**
	 * 
	 * 统计条数
	 * @return
	 */
	public int count() {
		String sql="select count(d.d_id) as bcount from dishes d ";
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
	 * 分页查询菜品类型
	 * @param firstResult
	 * @param i
	 * @return
	 */
	public List<Map<String, Object>> findDishesList(int firstResult, int maxResult) {
		String sql="SELECT * from  dishes d  ORDER BY d.d_id DESC LIMIT ?,?";	
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
				map.put("d_id", rs.getInt(1));
				map.put("d_type", rs.getString(2));
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
