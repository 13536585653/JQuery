package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import bean.Users;


public class UsersDao{
	public boolean login(String mail,String password){
		boolean bl =false;
		String sql="select count(*) from users where mailbox=? and password=?";
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs = null;
		try{
			conn = UR.getCon();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, password);
			rs = ps.executeQuery();
			if(rs.next()){
				int n = rs.getInt(1);
				bl = n>0;
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(rs, ps, conn);
		}
		return bl;
	}
	
	public boolean regist(Users u){
		boolean bl = false;
		String sql ="insert users(mailbox,[password],nickname,sex) values(?,?,?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=UR.getCon();
			ps = conn.prepareStatement(sql);
			ps.setString(1, u.getMailbox());
			ps.setString(2, u.getPassword());
			ps.setString(3, u.getNikename());
			ps.setInt(4, u.getSex());
			bl = ps.execute();
			
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(null, ps, conn);
		}
		return bl;
	}
	
	public String getname(String mail){
		String sql ="select nickname from users where mailbox = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String nickname = null;
		try{
			conn=UR.getCon();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mail);
			rs = ps.executeQuery();
			while(rs.next()){
				nickname = rs.getString("nickname");
		}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(null, ps, conn);
		}
		return nickname;
	}

}
