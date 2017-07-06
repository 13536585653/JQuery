package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.demo.entity.BType;
import org.demo.utils.DBUtil;

public class BTypeDao {
	/**
	 * 查询书籍类型的dao
	 * 
	 */
	public List<BType> findType(){
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<BType> list=new ArrayList<BType>();
		String sql="select * from book_type";
		
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				BType type=new BType();
				type.setTid(rs.getInt(1));
				type.setTname(rs.getString(2));
				list.add(type);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return list;
	}
}
