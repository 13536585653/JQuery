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

import org.order.bean.HelpType;
import org.order.bean.Menu;
import org.order.bean.Test;
import org.order.utils.DBConnection;



public class MenuDao {
	
	/**
	 * 
	 * 分页查询
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<Map<String,Object>> findBookList(int firstResult,int maxResult){
	String sql="SELECT m.m_id,m.jx,m.m_name,m.m_price,m.m_image ,m.d_id ,s.d_type,m.jx from  menu m left join dishes s on  m.d_id=s.d_id  ORDER BY m.m_time DESC LIMIT ?,? ";	
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
			map.put("m_id", rs.getInt(1));
			map.put("m_name", rs.getString(3));
			map.put("m_price", rs.getFloat(4));
			map.put("m_image", rs.getString(5));
			map.put("d_type", rs.getString(7));
			map.put("jx", rs.getInt(8));
			list.add(map);
		}
		
	} catch (SQLException e) {
		e.printStackTrace();
	}finally {
		DBConnection.close(rs, pstm, conn);
	}
	return list;
}
	
	//查询总记录数
	public int count(){
		String sql="select count(b.m_id) as bcount from menu b left join dishes t on b.d_id=t.d_id where b.jx=0";
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
	 * 妫�煡璇ヨ彍鍗曞悕鏄惁瀛樺湪
	 * @param menu
	 * @return
	 */
	public Menu check(Menu menu) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select * from menu where m_name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, menu.getM_name());
			rs=ps.executeQuery();
			if(rs.next()){
				menu.setM_name(rs.getString(2));
				return menu;
			}
		} catch (SQLException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		}
		return null;
	}

	
	/**
	 * 
	 *娣诲姞鑿滃崟
	 * @param menu
	 * @return
	 */
	public int addmenu(Menu menu) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n=0;
		String sql="insert into menu values(null,?,?,?,?,default,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, menu.getM_name());
			ps.setFloat(2, menu.getM_price());
			ps.setString(3, menu.getM_img());
			ps.setString(4, menu.getM_description());
			ps.setTimestamp(5,  new Timestamp(new Date().getTime()));
			ps.setInt(6, menu.getD_id());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 锟皆讹拷锟斤拷锟缴碉拷 catch 锟斤拷
			e.printStackTrace();
		}
		return n;
	}

	/**
	 * 
	 * 鎵归噺鍒犻櫎
	 * @param ids
	 * @return
	 */
	public int[] deletemenu(int[] ids) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstm=null;
		int [] row=null;
		String sql="delete from menu where m_id=?";
		try {
			pstm=conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			for (int i : ids) {
				pstm.setInt(1, i);
				pstm.addBatch();
			}
			row=pstm.executeBatch();
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
			DBConnection.close(null, pstm, conn);
		}
		return row;
	}

	
	/**
	 * 
	 * 褰撲釜鍒犻櫎鐨勬柟娉�
	 * @param s
	 */


	public int delete1(int id1) {
		// TODO 鑷姩鐢熸垚鐨勬柟娉曞瓨鏍�
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="delete from menu where m_id=?";
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
	 * 鍏抽敭瀛楁煡璇�
	 * @param string
	 * @param params
	 * @return
	 */
	public List<Map<String,Object>> find(String sql, List<Object> params) {
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Map<String ,Object>> list=new ArrayList<Map<String ,Object>>();
		Connection conn=DBConnection.getConnection();
		try {
			ps=conn.prepareStatement(sql);
			for (int i = 0; i<params.size(); i++) {
				ps.setObject(i+1, params.get(i));								
			}
			rs=ps.executeQuery();
			while(rs.next()){
				Map<String ,Object> map=new HashMap<String ,Object>();
				map.put("m_id", rs.getInt(1));
				map.put("m_name", rs.getString(2));
				map.put("m_price", rs.getFloat(3));
				map.put("m_img", rs.getString(4));
				map.put("d_type", rs.getString(8));
				map.put("d_id", rs.getInt(6));
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		return list;
	}


	public Map<String, Object> select(int ids) {
		
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from menu m LEFT JOIN dishes d on m.d_id=d.d_id where m_id=?";
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, ids);
			rs=ps.executeQuery();
			while(rs.next()){
				
				map.put("m_name", rs.getString(2));
				map.put("m_id", rs.getInt(1));
				map.put("m_price", rs.getString(3));
				map.put("m_img", rs.getString(4));
				map.put("d_type", rs.getString(8));
				map.put("d_id", rs.getInt(6));
				map.put("description", rs.getString(5));
				
			}
		} catch (SQLException e) {
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		return map;
	}


	
	//编辑菜
	public int update(Menu menu) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="update menu set m_name=? , m_image=?,m_price=? , m_description=? , d_id=? ,m_time=?  where m_id =?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, menu.getM_name());
			ps.setString(2, menu.getM_img());
			ps.setFloat(3, menu.getM_price());
			ps.setString(4, menu.getM_description());
			ps.setInt(5, menu.getD_id());
			ps.setTimestamp(6,  new Timestamp(new Date().getTime()));
			ps.setInt(7, menu.getM_id());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		return n;
	}

	public Map<String, Object> selectById(int id,int num) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from  menu where m_id=?";
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				map.put("id", rs.getInt(1));
				map.put("m_name", rs.getString(2));
				map.put("m_price", rs.getFloat(3));
				map.put("m_img", rs.getString(4));
				map.put("m_description", rs.getString(5));	
				
				map.put("num", num);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return map;
	}
	public int update1(Menu menu) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="update menu set m_name=?,m_price=? , m_description=? , d_id=? ,m_time=?  where m_id =?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, menu.getM_name());
			ps.setFloat(2, menu.getM_price());
			ps.setString(3, menu.getM_description());
			ps.setInt(4, menu.getD_id());
			ps.setTimestamp(5,  new Timestamp(new Date().getTime()));
			ps.setInt(6, menu.getM_id());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 鑷姩鐢熸垚鐨�catch 鍧�
			e.printStackTrace();
		}
		return n;
	}

	public Menu selectById2(int id, int num) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Menu m=null;
		String sql="select * from  menu where m_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
				m=new Menu();
				m.setM_id(rs.getInt(1));
				m.setM_name(rs.getString(2));
				m.setM_price(rs.getFloat(3));
				m.setM_description(rs.getString(5));
				m.setM_img(rs.getString(4));
				m.setNum(num);
				return m;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return null;

	}
	

}
