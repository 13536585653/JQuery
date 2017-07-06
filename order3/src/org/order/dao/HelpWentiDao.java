package org.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.order.bean.HelpType;
import org.order.bean.HelpWenti;
import org.order.utils.DBConnection;

public class HelpWentiDao {
	
	//查询总记录数
			public int count(){
				String sql="select count(b.w_id) as bcount from wenti b left join help t on b.h_id=t.h_id";
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
	
			//查询分页记录
			//firstResult表示从哪里开始查，maxResult表示最大查多少条
			public List<Map<String,Object>> findBookList(int firstResult,int maxResult){
				String sql="select w.w_id ,w.w_wenti,w.w_daan, h.h_type from wenti w inner join help h on w.h_id=h.h_id order by w.w_id desc LIMIT ?,? ";	
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
						map.put("w_id", rs.getInt(1));
						map.put("w_wenti",rs.getString(2));
						map.put("w_daan", rs.getString(3));
						HelpType type=new HelpType();
						type.setH_type(rs.getString(4));
						map.put("type", type.getH_type());
						list.add(map);
					}
					
				} catch (SQLException e) {
					e.printStackTrace();
				}finally {
					DBConnection.close(rs, pstm, conn);
				}
				return list;
			}
	
	
	
			public List<Map<String,Object>> findMenuList(int firstResult,int maxResult){
				/*StringBuilder sb=new StringBuilder();
				sb.append("select * from(select ROW_NUMBER() over(order by m.m_id) as rownum, ");
				sb.append("m.m_id,m.m_img,m.m_name,m.m_price,t.t_type from ");
				sb.append("menus m left join typess t on m.m_id=t.t_id ) as books where books.rownum between ? and ?");
				*/
				String sql="select * from(select ROW_NUMBER() over(order by b.w_id) as rownum,b.w_wenti,b.w_daan,t.h_type from wenti b left join help t on b.ww_id=t.h_id ) as tt where tt.rownum between ? and ?  ";	
			    
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
							map.put("w_wenti", rs.getInt(2));
							map.put("w_daan", rs.getString(3));
							HelpType type=new HelpType();
							type.setH_type(rs.getString(4));
							map.put("type", type.getH_type());
							list.add(map);
						}
					} catch (SQLException e) {
						e.printStackTrace();
					}finally {
						DBConnection.close(rs, pstm, conn);
					}
					return list;
				}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//总记录数
	public List<Map<String,Object>> FindWenti(){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		String sql="select w.w_wenti,w.w_daan, h.h_type from wenti w inner join help h on w.h_id=h.h_id";
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		try {
			pstm=conn.prepareStatement(sql);
			rs=pstm.executeQuery();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("w_wenti", rs.getString(1));
				map.put("w_daan", rs.getString(2));
				HelpType type=new HelpType();
				type.setH_type(rs.getString(3));
				map.put("type", type.getH_type());
				list.add(map);
			}
		} catch (SQLException e) {
			  // TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, pstm, conn);
		}
		return list;
	}
	
	
	//添加
	public int addType(HelpWenti wenti){
		String sql="insert into wenti values(null,?,?,?)";
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstm=null;
		int i=0;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, wenti.getW_wenti());
			pstm.setString(2, wenti.getW_daan());
			pstm.setInt(3, wenti.getType().getH_id());
			i=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}
	/*public static void main(String[] args) {
		HelpWentiDao dao=new HelpWentiDao();
		List list=dao.FindWenti();
		System.out.println(list);
	}*/
	

	public int[] removeHelp(int[] ids){
		Connection conn=null;
		PreparedStatement ps=null;
		int[] rows=null;
		String sql="delete from wenti where w_id=?";
		try{
			conn=DBConnection.getConnection();
			//设置自动提交为手动提交
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			for (int bid : ids) {
				ps.setInt(1, bid);
				//添加到批量缓存中
				ps.addBatch();
			}
			//ִ执行批量操作
			rows=ps.executeBatch();
			//手动提交事务
			conn.commit();

		}catch(SQLException e){
			e.printStackTrace();
			try{
				//如果失败，进行事务回滚操作
				conn.rollback();
			}catch(SQLException e1){
				
			};
		}finally{
			//关闭连接
			DBConnection.close(null, ps, conn);
		}
		return rows;
	}

	public Map<String,Object> getWentiById(int id) {
		Connection conn=DBConnection.getConnection();
		String sql="select w_id, w.w_wenti,w.w_daan, h.h_type,h.h_id from wenti w inner join help h on w.h_id=h.h_id where w_id=? ";
		PreparedStatement pstm=null;
		ResultSet rs=null;
		HelpWenti we=null;
		Map<String,Object> map=null;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, id);
			rs=pstm.executeQuery();
			while(rs.next()){
			we=new HelpWenti();
			 map=new HashMap<String,Object>();
			map.put("w_id", rs.getInt(1));
			map.put("w_wenti", rs.getString(2));
			map.put("w_daan", rs.getString(3));
			map.put("type",rs.getString(4));
			map.put("h_id", rs.getInt(5));
				/*we.setW_id(rs.getInt(1));
				we.setW_wenti(rs.getString(2));
				we.setW_daan(rs.getString(3));
				HelpType type=new HelpType();
				type.setH_id(rs.getInt(5));
				type.setH_type(rs.getString(4));
				we.setType(type);*/
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return map;
	}

	public int updateWenti(HelpWenti we) {
		String sql="update wenti set w_wenti=?,w_daan=?,h_id=? where w_id=? ";
		Connection conn=DBConnection.getConnection();
		PreparedStatement pstm=null;
		int i=0;
		try {
			pstm=conn.prepareStatement(sql);
			pstm.setString(1, we.getW_wenti());
			pstm.setString(2, we.getW_daan());
			pstm.setInt(3, we.getType().getH_id());
			pstm.setInt(4, we.getW_id());
			i=pstm.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return i;
	}

}
