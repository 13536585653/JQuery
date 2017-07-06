package org.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.demo.entity.Book;
import org.demo.utils.DBUtil;
import org.junit.Test;

public class BookDao {
	/**
	 * 查询全部书籍的方法
	 * 
	 */
	//list用于存放多条数据，而list中的 每一个map就是对应一条（行）记录
	public List<Map<String,Object>> findBooks(){
		StringBuilder sb=new StringBuilder();
		sb.append("select  b.b_id,b.b_name,b.create_time,t.t_name ");
		sb.append("from book_info b left join book_type t on b.tid=t.t_id order by b_id desc");
		/*String sql="select  b.b_id,b.b_name,b.create_time,t.t_name from book_info b left join book_type t on b.tid=t.t_id";*/
		Connection conn=DBUtil.getConnection();
		PreparedStatement pstm=null;
		ResultSet rs=null;
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		try {
			pstm=conn.prepareStatement(sb.toString());
			rs=pstm.executeQuery();
			while(rs.next()){
				//没循环一次，自建一个map对象,一个map就对应一条记录
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("bid", rs.getString(1));
				map.put("bookname", rs.getString(2));
				map.put("createtime", rs.getDate(3));
				map.put("typename", rs.getString(4));
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 测试查询全部书籍的方法
	 */
	@Test
	public void main() {
		List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
		for(Map<String, Object>map:list){
			for(String key:map.keySet()){
				System.out.println(key+":"+map.get(key));
			}
				System.out.println("---------------------");
		}
	}
	
	/**
	 * 添加书籍信息
	 * 
	 */
	public int save(Book book){
		Connection conn=null;
		PreparedStatement ps=null;
		int i=0;
		String sql="insert into book_info values(?,?,?)";
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, book.getBname());
			ps.setDate(2, book.getCreateTime());
			ps.setInt(3, book.getTid());
			i=ps.executeUpdate();
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(null, ps, conn);
		}
		return i;
	}
	
	//根据ID查询某个书籍的信息
	public Map<String ,Object> findBookById(int bid){
		StringBuilder sql=new StringBuilder();
		sql.append("select  b.b_id,b.b_name,b.create_time,t.t_name ");
		sql.append("from book_info b left join book_type t on b.tid=t.t_id ");
		sql.append("where b_id=?");
		Map<String,Object> map=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		try{
			conn=DBUtil.getConnection();
			ps=conn.prepareStatement(sql.toString());
			ps.setInt(1, bid);
			rs=ps.executeQuery();
			if(rs.next()){
				map=new HashMap<String,Object>();
				map.put("bid", rs.getInt(1));
				map.put("bookName", rs.getString(2));
				map.put("createTime", rs.getDate(3));
				map.put("typeName", rs.getString(4));
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally{
			DBUtil.close(rs, ps, conn);
		}
		return map;
	}
	/**
	 *
	 * 批量删除操作的方法
	 */
	public int[] removeBooks(int[] bids){
		Connection conn=null;
		PreparedStatement ps=null;
		int[] rows=null;
		String sql="delete from book_info where b_id=?";
		try{
			conn=DBUtil.getConnection();
			//设置自动提交为手动提交
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			for (int bid : bids) {
				ps.setInt(1, bid);
				//添加到批量缓存中
				ps.addBatch();
			}
			//ִ执行批量操作
			rows=ps.executeBatch();
			//手动提交事务
			conn.commit();

		}catch(SQLException e){
			e.printStackTrace();
			try{
				//如果失败，进行事务回滚操作
				conn.rollback();
			}catch(SQLException e1){

			};
		}finally{
			//关闭连接
			DBUtil.close(null,ps,conn);
		}
		return rows;
	}
	//测试批量操作的方法
		//@Test
		public void testRemovebooks(){
			int[] mid=new int[2];
			mid[1]=234;
			mid[0]=234;
			BookDao dao=new BookDao();
			int[] rows=dao.removeBooks(mid);
			String msg=rows==null?"失败":"成功";
			System.out.println(msg);
		}
		
	/**
	 * 更新书籍信息
	 */
		public int updateBook(Book book){
			Connection conn=null;
			PreparedStatement ps=null;
			int i=0;
			String sql="Update book_info set b_name=?,create_time=?,tid=? where b_id=?";
			
			try{
				conn=DBUtil.getConnection();
				ps=conn.prepareStatement(sql);
				ps.setString(1, book.getBname());
				ps.setDate(2, book.getCreateTime());
				ps.setInt(3, book.getTid());
				ps.setInt(4, book.getBid());
				i=ps.executeUpdate();
			}catch(SQLException e){
				e.printStackTrace();
			}finally{
				DBUtil.close(null, ps, conn);
			}
			return i;
		}
}
