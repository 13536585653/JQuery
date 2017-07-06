package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class DanmuDao {
	public boolean in(String mail,String danmu){
		boolean bl = false;
		String sql ="insert into users values(?,?)";
		Connection conn = null;
		PreparedStatement ps = null;
		try{
			conn=UR.getCon();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mail);
			ps.setString(2, danmu);
			bl = ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(null, ps, conn);
		}
		return bl;
	}
	
	public List<String> getAll(){
		List<String> danmu = new ArrayList<String>();
		String sql ="select danmu from danmu";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn=UR.getCon();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
				danmu.add(rs.getString("danmu"));
			}
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(rs, ps, conn);
		}
		return danmu;
	}
	
	public boolean delete(String mail){
		boolean bl = false;
		String sql ="delete from danmu where mailbox = ?";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try{
			conn=UR.getCon();
			ps = conn.prepareStatement(sql);
			ps.setString(1, mail);
			bl = ps.execute();
		}catch (Exception e){
			e.printStackTrace();
		}finally{
			UR.closeAll(rs, ps, conn);
		}
		return bl;
	}
}
