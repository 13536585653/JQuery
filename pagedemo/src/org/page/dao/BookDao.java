package org.page.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.page.utils.DBUtil;

public class BookDao {
	//查询总记录数
		public int count(){
			String sql="select count(b.b_id) as bcount from book_info b left join book_type t on b.tid=t.t_id;";
			Connection conn=DBUtil.getConnection();
			PreparedStatement ps=null;
			ResultSet rs=null;
			int rowCount=0;
			try {
				ps=conn.prepareStatement(sql);
				rs=ps.executeQuery();
				rs.next();
				rowCount=rs.getInt(1);
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				DBUtil.close(rs, ps, conn);
			}
			return rowCount;
		}
		//查询分页记录
		//firstResult表示从哪里开始查，maxResult表示最大查多少条(查到哪里)
		public List<Map<String,Object>> findBookList(int firstResult,int maxResult){
			String sql="select * from(select ROW_NUMBER() over(order by b.b_id) as rownum,b.b_id,b.b_name,b.create_time,b.tid,t.t_name from book_info b left join book_type t on b.tid=t.t_id ) as books where books.rownum between ? and ?";	
		    PreparedStatement pstm=null;
		    Connection conn=null;
		    ResultSet rs=null;
		    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		    try {
		    	conn=DBUtil.getConnection();
				pstm=conn.prepareStatement(sql);
				pstm.setInt(1, firstResult);
				pstm.setInt(2, maxResult);
				rs=pstm.executeQuery();
				while(rs.next()){
					Map<String,Object> map=new HashMap<String,Object>();
					map.put("bid", rs.getInt(2));
					map.put("bookName", rs.getString(3));
					map.put("createTime", rs.getDate(4));
					map.put("typeName", rs.getString(6));
					list.add(map);
				}
				
			} catch (SQLException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}finally {
				DBUtil.close(null, pstm, conn);
			}
			return list;
		}
		@Test
		public  void main() {
			BookDao dao=new BookDao();
			List<Map<String,Object>> list=dao.findBookList(3,5);
			//System.out.println(list.size());
			System.out.println(list);
		}
}
