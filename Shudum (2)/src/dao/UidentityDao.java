package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import bean.Uidentity;


public class UidentityDao {
	public List<Uidentity> getAll(){
		List<Uidentity> list = new ArrayList<Uidentity>();
		String sql="select mailbox,uidentity from uidentity";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn=UR.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		while(rs.next()){
			Uidentity sr = new Uidentity();
			sr.setMailbox(rs.getString("mailbox"));
			sr.setUidentity(rs.getString("uidentity"));
			list.add(sr);
		}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(rs, ps, conn);
		}
		return list;
	}
	
	public String getOne(String mail){
		String sql="select uidentity from uidentity where mailbox = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String uidentity = null;
		try{
			conn=UR.getCon();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
		while(rs.next()){
			uidentity = rs.getString("uidentity");			
		}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(rs, ps, conn);
		}
		return uidentity;
	}
	
	
	
	
	
	
	public boolean insert(String mail,String uidentity){
		boolean bl=false;
		String sql="insert uidentity(mailbox,uidentity) values(?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=UR.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, uidentity);
			int n=ps.executeUpdate();
			bl = n > 0;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(null, ps, conn);
		}
		return bl;
	}
	
	public boolean delete(String mail){
		boolean bl=false;
		String sql="delete from uidentity where mailbox = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=UR.getCon();
			ps=conn.prepareStatement(sql);
			ps.setString(1, mail);
			int n=ps.executeUpdate();
			bl = n > 0;
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(null, ps, conn);
		}
		return bl;
	}
}
