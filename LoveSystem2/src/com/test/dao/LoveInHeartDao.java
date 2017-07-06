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
		//���
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
		
		//��ѯ����
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
		
		//ͨ��id����û���������Ϣ
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
		
		//ͨ��id��ѯ�û���������Ϣ��ajax��
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
		//ͨ��id���޸��û���Ϣ
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
		//ɾ���û�
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
		//����ɾ��
		public int[] removeLove(int[] lids) {
			String sql = "delete from LoveInHeart where lid=?";
			Connection conn = null;	
			PreparedStatement pstm = null;
			int[] rows = null;
			try{
				//ͨ�����Ӷ������ǽ�conn���Զ������ύ��Ϊ�ֶ������ύ
				conn = DBUtil.getConnection();
				conn.setAutoCommit(false);
				pstm = conn.prepareStatement(sql);
				for (int lid : lids) {
					//���ò�ͬ�Ĳ���
					pstm.setInt(1, lid);
					//��ӵ����������Ļ�����
					pstm.addBatch();
				}
				//ִ����������
				rows = pstm.executeBatch();
				//�ֶ����ύ����
				conn.commit();
			}catch(SQLException e){
				e.printStackTrace();
				//�������������Ļع�����
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
				love.setLsex("��");
				love.setLname("l");
				love.setLmoney(38);
				love.setLtime(Date.valueOf("1995-08-09"));
				int i=dao.deleteLove(3);
				System.out.println(i);
//				love.setLmoney(11);
//				love.setLname("1");
//				love.setLsex("��");
//				love.setLtime(Date.valueOf("1995-08-09"));
//				System.out.println(dao.add(love));
				
			 	List<LoveInHeart> list=dao.all();
			 	for (LoveInHeart loveInHeart : list) {
					System.out.println(loveInHeart);
				}
			}

		
}
