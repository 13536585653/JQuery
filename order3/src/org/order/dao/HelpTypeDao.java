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
import org.order.utils.DBConnection;


public class HelpTypeDao {
		public List<Map<String, Object>> findHelpType(){
			List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
			String sql="select * from help";
			Connection conn=DBConnection.getConnection();
			PreparedStatement pstm=null;
			ResultSet rs=null;
			
			try {
				pstm=conn.prepareStatement(sql);
				rs=pstm.executeQuery();
				while(rs.next()){
					
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("h_id", rs.getInt(1));
					map.put("h_type", rs.getString(2));
					list.add(map);
					
					/*type=new HelpType();
					type.setH_id(rs.getInt(1));
					type.setH_type(rs.getString(2));
					list.add(type);*/
				}
			} catch (SQLException e) {
				  // TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				DBConnection.close(rs, pstm, conn);
			}
			return list;
		}
		
		public static void main(String[] args) {
			HelpTypeDao dao=new HelpTypeDao();
			List<Map<String, Object>> list=dao.findHelpType();
			System.out.println(list);
		}

		public int addHelpTypeDao(String type) {
			String sql="insert into help values(null,?)";
			Connection conn=DBConnection.getConnection();
			PreparedStatement pstm=null;
			int i=0;
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, type);
				i=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			return i;
		}
		
		/**
		 *
		 * 批量删除操作的方法
		 */
		public int[] removeHelp(int[] ids){
			Connection conn=null;
			PreparedStatement ps=null;
			int[] rows=null;
			String sql="delete from help where h_id=?";
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

		public HelpType getHelpTypeById(int id) {
			List<HelpType> list=new ArrayList<HelpType>();
 			String sql="select * from help where h_id=?";
			Connection conn=DBConnection.getConnection();
			PreparedStatement pstm=null;
			ResultSet rs=null;
			HelpType ty=null;
			//HelpType t=null;
					try {
						pstm=conn.prepareStatement(sql);
						pstm.setInt(1, id);
						rs=pstm.executeQuery();
						if(rs.next()){
							ty=new HelpType();
							ty.setH_id(rs.getInt(1));
							ty.setH_type(rs.getString(2));
						}
					} catch (SQLException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}finally {
						DBConnection.close(null,pstm, conn);
					}
			return ty;
		}

		public int updateHelpType(HelpType ty) {
			int i=0;
			String sql="update help set h_type=? where h_id=?";
			Connection conn=DBConnection.getConnection();
			PreparedStatement pstm=null;
			
			try {
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, ty.getH_type());
				pstm.setInt(2, ty.getH_id());
				i=pstm.executeUpdate();
				System.out.println(i);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
			return i;
		}
	
}
