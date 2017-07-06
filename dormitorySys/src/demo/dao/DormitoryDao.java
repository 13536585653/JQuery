package demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import demo.entity.Dormitory;
import demo.utils.DBUtil;

public class DormitoryDao {
	/**
	 * 添加学员的方法
	 * @param user
	 * @return
	 */
	public boolean addUser(Dormitory d){
		boolean bl=false;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into dormitory values(?,?,?,?,?,?)";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, d.getDormitoryId() );
			ps.setString(2, d.getStuName());
			ps.setString(3, d.getStuSex());
			ps.setString(4, d.getClsName());
			ps.setDate(5, d.getInDate());
			ps.setInt(6, d.getBedNo());
			bl=ps.execute();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return bl;
	}
	
	//查询全部宿舍信息的方法
	public List<Map<String,Object>> findDormitory(){
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from dormitory";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("dormitoryId", rs.getString(1));
				map.put("stuName", rs.getString(2));
				map.put("stuSex", rs.getString(3));
				map.put("clsName", rs.getString(4));
				map.put("inDate", rs.getDate(5));
				map.put("bedNo", rs.getInt(6));
				list.add(map);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
		
	}
	
}
