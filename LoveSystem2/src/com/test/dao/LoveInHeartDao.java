package com.test.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.test.bean.LoveInHeart;
import com.test.util.DBUtil;

public class LoveInHeartDao {
		//添加
		public int add(LoveInHeart love){
			String sql="insert into LoveInHeart values(?,?,?,?)";
			Connection conn=null;
			PreparedStatement pstm=null;
			int i=0;
			try {
				conn=DBUtil.getConnection();
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, love.getLname());
				pstm.setString(2, love.getLsex());
				pstm.setDate(3, love.getLtime());
				pstm.setInt(4, love.getLmoney());
				i=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.close(pstm, conn, null);
			}
			return i;
		}
		
		//查询所有
		public List<LoveInHeart> all(){
			List<LoveInHeart> list=new ArrayList<LoveInHeart>();
			String sql="select * from LoveInHeart";
			Connection conn=null;
			PreparedStatement pstm=null;
			ResultSet rs=null;
			try {
				conn=DBUtil.getConnection();
				pstm=conn.prepareStatement(sql);
				rs=pstm.executeQuery();
				while(rs.next()){
					LoveInHeart love=new LoveInHeart();
					love.setLid(rs.getInt(1));
					love.setLname(rs.getString(2));
					love.setLsex(rs.getString(3));
					love.setLtime(rs.getDate(4));
					love.setLmoney(rs.getInt(5));
					list.add(love);
					
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.close(pstm, conn, rs);
			}
			return list;
		}
		
		//通过id查该用户的所有信息
		public LoveInHeart findLoveById(int lid){
			String sql="select * from LoveInHeart where lid=?";
			Connection conn=null;
			PreparedStatement pstm=null;
			ResultSet rs=null;
			try {
				conn=DBUtil.getConnection();
				pstm=conn.prepareStatement(sql);
				pstm.setInt(1, lid);
				rs=pstm.executeQuery();
				if(rs.next()){
					LoveInHeart love=new LoveInHeart();
					love.setLid(rs.getInt(1));
					love.setLname(rs.getString(2));
					love.setLsex(rs.getString(3));
					love.setLtime(rs.getDate(4));
					love.setLmoney(rs.getInt(5));
					return love;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.close(pstm, conn, rs);
			}
			return null;
		}
		
		//通过id查询用户的所有信息（ajax）
		public Map<String,Object> findById(int lid){
			String sql="select * from LoveInHeart where lid=?";
			Connection conn=null;
			PreparedStatement pstm=null;
			ResultSet rs=null;
				try {
					conn=DBUtil.getConnection();
					pstm=conn.prepareStatement(sql);
					pstm.setInt(1, lid);
					rs=pstm.executeQuery();
					while(rs.next()){
						Map<String,Object> map=new HashMap<String,Object>();
						map.put("lid", rs.getInt(1));
						map.put("lname", rs.getString(2));
						map.put("lsex", rs.getString(3));
						map.put("ltime", rs.getDate(4));
						map.put("lmoney", rs.getInt(5));
						return map;
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally{
					DBUtil.close(pstm, conn, rs);
				}
				return null;
		}
		//通过id来修改用户信息
		public int updateLove(LoveInHeart love){
			String sql="update LoveInHeart set lname=?,lsex=?,ltime=?,lmoney=? where lid=?";
			Connection conn=null;
			PreparedStatement pstm=null;
			int i=0;
			try {
				conn=DBUtil.getConnection();
				pstm=conn.prepareStatement(sql);
				pstm.setString(1, love.getLname());
				pstm.setString(2, love.getLsex());
				pstm.setDate(3, love.getLtime());
				pstm.setInt(4, love.getLmoney());
				pstm.setInt(5, love.getLid());
				i=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.close(pstm, conn, null);
			}
			return i;
		}
		//删除用户
		public int deleteLove(int lid){
			String sql="delete from LoveInHeart where lid=?";
			Connection conn=null;
			PreparedStatement pstm=null;
			int i=0;
			try {
				conn=DBUtil.getConnection();
				pstm=conn.prepareStatement(sql);
				pstm.setInt(1, lid);
				i=pstm.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}finally{
				DBUtil.close(pstm, conn, null);
			}
			return i;
		};
		//批量删除
		public int[] removeLove(int[] lids) {
			String sql = "delete from LoveInHeart where lid=?";
			Connection conn = null;	
			PreparedStatement pstm = null;
			int[] rows = null;
			try{
				//通过连接对象，我们将conn的自动事务提交改为手动事务提交
				conn = DBUtil.getConnection();
				conn.setAutoCommit(false);
				pstm = conn.prepareStatement(sql);
				for (int lid : lids) {
					//设置不同的参数
					pstm.setInt(1, lid);
					//添加到批量操作的缓存中
					pstm.addBatch();
				}
				//执行批量操作
				rows = pstm.executeBatch();
				//手动来提交事务
				conn.commit();
			}catch(SQLException e){
				e.printStackTrace();
				//在这里进行事务的回滚操作
				try {
					conn.rollback();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}finally{
				DBUtil.close(pstm, conn, null);;
			}
			return rows;
			
		}
		public static void main(String[] args) {
				LoveInHeartDao dao=new LoveInHeartDao();
				Map<String,Object> map=dao.findById(56);
				for (String key : map.keySet()) {
						System.out.println(key+"222"+map.get(key));
				}
				LoveInHeart love =new LoveInHeart();
				love.setLid(3);
				love.setLsex("男");
				love.setLname("l");
				love.setLmoney(38);
				love.setLtime(Date.valueOf("1995-08-09"));
				int i=dao.deleteLove(3);
				System.out.println(i);
//				love.setLmoney(11);
//				love.setLname("1");
//				love.setLsex("男");
//				love.setLtime(Date.valueOf("1995-08-09"));
//				System.out.println(dao.add(love));
				
			 	List<LoveInHeart> list=dao.all();
			 	for (LoveInHeart loveInHeart : list) {
					System.out.println(loveInHeart);
				}
			}

		
}
