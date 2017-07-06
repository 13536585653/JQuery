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
 * 查询所有会员的dao
 * 
 * @author LIANG
 *
 */
public class menbersDao {

	public List<UserBean> selectmember() {
		List<UserBean> list = new ArrayList<UserBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from users where rid=1";
		try {
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				UserBean u = new UserBean();
				u.setUid(rs.getInt(1));
				u.setUname(rs.getString(2));
				u.setUaddr(rs.getString(5));
				u.setUtel(rs.getString(7));
				u.setUmonetary(rs.getFloat(8));
				u.setRid(rs.getInt(9));
				list.add(u);
			}
		} catch (SQLException e) {
			// TODO
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * 单个删除
	 * @param id1
	 * @return
	 */
	public int delete1(int id1) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "delete from users where u_id=?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id1);
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;

	}

	
	
	/**
	 * 
	 * 修改信息
	 * @param u
	 * @return
	 */
	public int update(UserBean u) {
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		int n = 0;
		String sql = "update users set u_name=? , u_email=? ,u_tel=? ,u_addr=? ,u_sex=?,rid=? ,up_time =? where u_id =?";
		try {
			ps = conn.prepareStatement(sql);			
			ps.setString(1, u.getUname());
			ps.setString(2, u.getUemail());
			ps.setString(3, u.getUtel());
			ps.setString(4, u.getUaddr());
			ps.setString(5, u.getUsex());
			ps.setInt(6, u.getRid());
			ps.setInt(8, u.getUid());
			ps.setTimestamp(7, new Timestamp(new Date().getTime()));
			n = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
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
		String sql="select count(s.u_id) as bcount from users s left join role r on s.rid=r.r_id where rid=2";
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
	 * 分页查询会员
	 * @param firstResult
	 * @param i
	 * @return
	 */
	public List<Map<String, Object>> findMenberList(int firstResult, int maxResult) {
		String sql="SELECT * from  users s left join role r on  s.rid=r.r_id  where s.rid=2 ORDER BY up_time DESC  LIMIT ?,?";	
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
