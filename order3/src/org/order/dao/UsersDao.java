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

import org.order.bean.UserBean;
import org.order.utils.DBConnection;



/**
 * 
 * 查询所有普通用户信息
 * 
 * @author LIANG
 *
 */
public class UsersDao {

	public List<UserBean> selectuser() {
		List<UserBean> list = new ArrayList<UserBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where rid=2";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserBean u = new UserBean();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setUmonetary(rs.getFloat(9));
			
				u.setRid(rs.getInt(10));
				u.setUaddr(rs.getString(5));
				u.setUemail(rs.getString(7));
				u.setUtel(rs.getString(6));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		return list;
	}

	
	/**
	 * 
	 * 批量删除用户
	 * @param ids
	 * @return
	 */
	public int[] delete(int[] ids) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int[] row = null;
		String sql = "delete from users where u_id=?";
		try {
			ps = conn.prepareStatement(sql);
			conn.setAutoCommit(false);
			for (int i : ids) {
				ps.setInt(1, i);
				ps.addBatch();
			}
			row = ps.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
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
	public int  delete1(int id1) {
		// TODO 自动生成的方法存根
				Connection conn=DBConnection.getConnection();
				PreparedStatement ps=null;
				int n=0;
				String sql="delete from users where u_id=?";
				try {
					ps=conn.prepareStatement(sql);
					ps.setInt(1, id1);
					n=ps.executeUpdate();
				} catch (SQLException e) {
					// TODO 自动生成的 catch 块
					e.printStackTrace();
				}
				return n;
				
			}



	/**
	 * 
	 * 通过指定id查询信息
	 * @param id
	 * @return
	 */
	public Map<String, Object> selectById(int id) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from users u LEFT JOIN role r on u.rid=r.r_id where u_id=?";
		Map<String,Object> map=new HashMap<String,Object>();
		try {
			
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			while(rs.next()){
				map.put("u_name", rs.getString(2));
				map.put("u_id", rs.getInt(1));
				map.put("u_sex", rs.getString(4));
				map.put("u_addr", rs.getString(5));
				map.put("u_email", rs.getString(7));
				map.put("u_tel", rs.getString(6));
				map.put("r_id", rs.getInt(10));
				map.put("type", rs.getString(11));
				
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return map;
		}
	
	/**
	 * 
	 * 修改用户信息
	 * @param u
	 * @return
	 */
	public int  update(UserBean u) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="update users set u_name=? , u_email=? ,u_tel=? ,u_addr=? ,u_sex=?,rid=? ,up_time=? where u_id =?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setString(1, u.getUname());
			ps.setString(2, u.getUemail());
			ps.setString(3, u.getUtel());
			ps.setString(4, u.getUaddr());
			ps.setString(5, u.getUsex());
			ps.setInt(6, u.getRid());
			ps.setTimestamp(7, new Timestamp(new Date().getTime()));
			ps.setInt(8, u.getUid());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}

	
	/**
	 * 
	 * 统计用户条数
	 * @return
	 */
	public int count() {
		String sql="select count(s.u_id) as bcount from users s left join role r on s.rid=r.r_id where rid=1";
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
	 * 分页查询用户
	 * @param firstResult
	 * @param maxResult
	 * @return
	 */
	public List<Map<String, Object>> findUserList(int firstResult, int maxResult) {
		String sql="SELECT * from  users s left join role r on  s.rid=r.r_id  where s.rid=1 ORDER BY up_time DESC  LIMIT ?,?";	
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
				
				Map<String ,Object> map=new HashMap<String ,Object>();
				map.put("u_id", rs.getInt(1));
				map.put("u_name", rs.getString(2));
				map.put("u_addr", rs.getString(5));
				map.put("u_tel", rs.getString(6));
				map.put("u_money", rs.getFloat(9));
				map.put("rid", rs.getInt(11));
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

