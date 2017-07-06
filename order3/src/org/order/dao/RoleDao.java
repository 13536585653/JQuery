package org.order.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.order.bean.RoleBean;
import org.order.utils.DBConnection;



public class RoleDao {

	public List<RoleBean> select() {
		List<RoleBean> list=new ArrayList<RoleBean>();
		Connection conn = DBConnection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql="select * from  role";
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				RoleBean r=new RoleBean();
				r.setRid(rs.getInt(1));
				r.setRtype(rs.getString(2));
				list.add(r);
			}
		} catch (SQLException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
		
		return list;
	}

}
