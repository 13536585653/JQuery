package org.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.order.bean.RoleBean;
import org.order.bean.UserBean;
import org.order.utils.DBConnection;



public class UserDao {
	/**
	 * ����û��ķ���
	 * @param user
	 * @return
	 */
	public int addUser(UserBean user){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into users values(null,?,?,?,?,?,?,?,?,null,?)";
		
		try{
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			ps.setString(3, user.getUsex());
			ps.setString(4, user.getUaddr());
			ps.setString(5, user.getUtel());
			ps.setTimestamp(7, user.getU_time());
			ps.setString(6, user.getUtel());
			ps.setFloat(8, user.getUmonetary());
			ps.setInt(9, user.getRid());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
		return i;
	}
	
	
	/**
	 * ����ɾ��ķ���
	 * @param usersid
	 * @return
	 */
	public int[] removeUsers(int[] usersid){
		Connection conn=null;
		PreparedStatement ps=null;
		int[] rows=null;
		String sql="delete from users where u_id=?";
		
		try{
			conn=DBConnection.getConnection();
			//ͨ�����ӣ�����conn�Զ��ύΪ�ֶ��ύ
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			for (int uid : usersid) {
				ps.setInt(1, uid);
				//��ӵ����������Ļ�����
				ps.addBatch();
			}
			//ִ����������
			rows=ps.executeBatch();
			//�ֶ��ύ����
			conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
			//��������ع�����
			try{
				conn.rollback();
			}catch(SQLException e2){
				e2.printStackTrace();
			}
		}finally{
			DBConnection.close(null, ps, conn);
		}
		return rows;
	}
	
	/**
	 * ��ѯĳ���û��ķ���
	 * @param user
	 * @return
	 */
	public UserBean findUserByName(UserBean user){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from users u inner join role  r on u.rid=r.r_id  where u_name=?";
		
		try{
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, user.getUname());
			rs=ps.executeQuery();
			if(rs.next()){
				UserBean newUser=new UserBean();
				newUser.setUid(rs.getInt(1));
				newUser.setUname(rs.getString(2));
				newUser.setUpwd(rs.getString(3));
				newUser.setUsex(rs.getString(4));
				newUser.setUaddr(rs.getString(5));
				newUser.setUemail(rs.getString(7));
				newUser.setUtel(rs.getString(6));
				newUser.setUmonetary(rs.getFloat(9));
				RoleBean role=new RoleBean();
				role.setR_ids(rs.getFloat(14));;
				newUser.setRtype(role);
				user.setRtype(role);
				return newUser;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, conn);
		}
		return null;
	}
	
	/**
	 * ��ѯȫ���û��ķ���
	 * @return
	 */
	public List<UserBean> findUsers(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<UserBean> list=new ArrayList<UserBean>();
		String sql="select * from users";
		try{
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				UserBean user=new UserBean();
				//user.setUid(rs.getInt(1));
				user.setUname(rs.getString(2));
				user.setUpwd(rs.getString(3));
				user.setUsex(rs.getString(4));
				user.setUaddr(rs.getString(5));
				user.setUaddr(rs.getString(6));
				user.setUemail(rs.getString(7));
				user.setUmonetary(rs.getFloat(8));
				RoleBean role=new RoleBean();
				role.setRtype(rs.getString(9));
				user.setRtype(role);
				list.add(user);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(rs, ps, conn);
		}
			return list;
	}
	/***
	 * �޸��û���Ϣ�ķ���
	 * @param user
	 * @return
	 */
	public int UpdateUser(UserBean user){
		int i=0;
		Connection conn=null;
		PreparedStatement ps=null;
		//���Ը������롢��ַ��email���͵绰��
		String sql="Update users set u_pwd=?,u_addr=?,u_email=?,u_tel=? where u_id=?";
		try{
			conn=DBConnection.getConnection();
			ps=conn.prepareStatement(sql);
			//ps.setString(1, user.getUname());
			ps.setString(2, user.getUpwd());
			//ps.setString(3, user.getUsex());
			ps.setString(4, user.getUaddr());
			ps.setString(5, user.getUemail());
			ps.setString(6, user.getUtel());
			//ps.setString(7, user.getRtype().getRtype());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBConnection.close(null, ps, conn);
		}
		return i;
		
	}
}
