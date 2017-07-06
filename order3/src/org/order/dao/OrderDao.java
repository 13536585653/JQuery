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

import org.order.bean.Order;
import org.order.utils.DBConnection;

public class OrderDao {
	
	/**	
	 * 
	 * 
	 * 查询所有订单信息
	 */
	public  List<Map<String ,Object>> selectorder2(int firstResult,int maxResult){
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<Map<String ,Object>> list=new ArrayList<Map<String ,Object>>();
		String sql = "select i.i_id,i.i_m_id, i.i_u_id, i.i_num,i.i_time,i.i_way,i.i_nunber,i.i_start,i.i_sun, m.m_name, u.u_addr,u.u_tel, u.u_email ,u.u_name"
					+" from indent as i  inner join menu as m on i.i_m_id=m.m_id inner join  users as u  on i.i_u_id=u.u_id ORDER BY i_time DESC LIMIT ?,?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, firstResult);
			ps.setInt(2, maxResult);
			rs=ps.executeQuery();
			while(rs.next()){
				//每循环一次创建一个map对象，一个map对应一条记录
				Map<String ,Object> map=new HashMap<String ,Object>();
				map.put("o_id", rs.getInt(1)); //id
				map.put("o_time", rs.getTimestamp(5));//时间
				map.put("o_number", rs.getString(7));//编号
				map.put("o_sum", rs.getFloat(9));//金额
				map.put("o_num", rs.getInt(4));//数量
				map.put("o_way", rs.getString(6));//方式
				map.put("o_state", rs.getInt(8));//状态
				map.put("m_name", rs.getString(10));//菜名
				map.put("u_addr", rs.getString(11));//地址
				map.put("u_name", rs.getString(14));//用户名
				list.add(map);
				System.out.println(rs.getTimestamp(5));
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}



	public int[]  delete(int[] ids) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstm=null;
		int [] row=null;
		String sql="delete from indent where i_id=?";
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
			// TODO 自动生成的 catch 块
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


	
	//发货
	public int update(int id, int state) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update indent set i_start=? where i_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, state);
			ps.setInt(2, id);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}

	
	/**
	 * 
	 * 用户添加订单的方法
	 * @param order
	 * @return
	 */
	public int addOrder(Order order) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql="insert into indent values(null,?,?,?,default,?,?,default,?,?)";
			try {
				ps=conn.prepareStatement(sql);
				ps.setString(1, order.getO_number()); //编号
				ps.setTimestamp(2, new Timestamp(new Date().getTime()));  //时间
				ps.setInt(3, order.getO_num()); // 数量
				ps.setInt(6, order.getO_m_id()); //菜的id		
				ps.setFloat(4, order.getO_sum());// 金额
				ps.setInt(7, order.getO_u_id()); // 用户id
				ps.setString(5, order.getMessage());
				n=ps.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return n;
		}

	
	//修改状态
	public int update(Order order) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql="update indent set i_way=? , i_start=? where i_nunber=?" ;
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, order.getO_way()); //编号
			ps.setInt(2, order.getO_state());
			ps.setString(3,order.getO_number());  
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}

	
	
	//查询订单的数量
	public int count() {
		String sql="select count(i.i_id) as bcount from indent i inner join users u on i.i_u_id=u.u_id inner join menu  m on i.i_m_id=m.m_id; ";
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
	 * 取消订单
	 * @param id
	 * @return
	 */

	public int quxorder(int id) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update indent set i_start=3 where i_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}



	public List<Map<String,Object>> selectOrderBymenber(String n) {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Map<String,Object> map=null;
		String sql = "select i.i_id,i.i_m_id, i.i_u_id, i.i_num,i.i_time,i.i_way,i.i_nunber,i.i_start,i.i_sun,u.u_addr,u.u_tel, u.u_email ,u.u_name,m.m_name"
					+" from indent as i  inner join menu as m on i.i_m_id=m.m_id left join  users as u  on i.i_u_id=u.u_id where i.i_nunber=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, n);
			rs=ps.executeQuery();
			while(rs.next()){
				//每循环一次创建一个map对象，一个map对应一条记录
			 map=new HashMap<String,Object>();
				map.put("o_id", rs.getInt(1)); //i
				map.put("o_time", rs.getTimestamp(5));//时间
				map.put("o_number", rs.getString(7));//编号
				map.put("o_sum", rs.getFloat(9));//金额
				map.put("o_num", rs.getInt(4));//数量
				map.put("o_way", rs.getString(6));//方式
				map.put("o_state", rs.getInt(8));//状态
				map.put("m_name", rs.getString(14));//菜名
				map.put("u_email", rs.getString(13));//邮箱
				map.put("u_addr", rs.getString(10));//地址
				map.put("u_tel", rs.getString(11));
				map.put("u_name", rs.getString(13));//用户名
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}



	public List<Map<String, Object>> selectOrderByName(String u_name) {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		Map<String,Object> map=null;
		String sql = "select i.i_id,i.i_m_id, i.i_u_id, i.i_num,i.i_time,i.i_way,i.i_nunber,i.i_start,i.i_sun,u.u_addr,u.u_tel, u.u_email ,u.u_name,m.m_name,m.m_image "
					+" from indent as i  inner join menu as m on i.i_m_id=m.m_id left join  users as u  on i.i_u_id=u.u_id where u.u_name=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, u_name);
			rs=ps.executeQuery();
			while(rs.next()){
				//每循环一次创建一个map对象，一个map对应一条记录
			 map=new HashMap<String,Object>();
				map.put("o_id", rs.getInt(1)); //i
				map.put("o_time", rs.getTimestamp(5));//时间
				map.put("o_number", rs.getString(7));//编号
				map.put("o_sum", rs.getFloat(9));//金额
				map.put("o_num", rs.getInt(4));//数量
				map.put("o_way", rs.getString(6));//方式
				map.put("o_state", rs.getInt(8));//状态
				map.put("m_name", rs.getString(14));//菜名
				map.put("u_email", rs.getString(13));//邮箱
				map.put("u_addr", rs.getString(10));//地址
				map.put("u_tel", rs.getString(11));
				map.put("u_name", rs.getString(13));//用户名
				map.put("m_image", rs.getString(15));//图片
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}
		

}
