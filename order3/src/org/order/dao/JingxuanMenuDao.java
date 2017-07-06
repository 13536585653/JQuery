package org.order.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.order.bean.Dishes;
import org.order.bean.HelpType;
import org.order.bean.JingxuanMenuBean;
import org.order.bean.Menu;
import org.order.utils.DBConnection;
import org.order.utils.GsonUtil;



public class JingxuanMenuDao {
	
	
	//查询总记录数
	public int count(){
		String sql="select count(b.m_id) as bcount from menu b left join dishes t on b.m_id=t.d_id where b.jx=1; ";
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int rowCount=0;
		try {
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			rs.next();
			rowCount=rs.getInt(1);
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, ps, conn);
		}
		return rowCount;
	}

	//查询分页记录
	//firstResult表示从哪里开始查，maxResult表示最大查多少条
	public List<Map<String,Object>> findBookList(int firstResult,int maxResult){
		String sql="SELECT m.m_id,m.jx,m.m_name,m.m_price,m.m_image ,m.d_id,m_description ,s.d_type from  menu m inner join dishes s on  m.d_id=s.d_id  where m.jx=1 ORDER BY m.m_id DESC LIMIT ?,?";

	    PreparedStatement pstm=null;
	    Connection conn=null;
	    ResultSet rs=null;
	    List<Map<String,Object>> list=new ArrayList<Map<String,Object>>();
	    try {
	    	conn=DBConnection.getConnection();
			pstm=conn.prepareStatement(sql);
			pstm.setInt(1, firstResult);
			pstm.setInt(2, maxResult);
			rs=pstm.executeQuery();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("id", rs.getInt(1));
				map.put("m_name", rs.getString(3));
				map.put("m_image", rs.getString(5));
				map.put("price", rs.getString(4));
				map.put("tecont", rs.getString(7));
				map.put("d_type", rs.getString(8));			
				list.add(map);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, pstm, conn);
		}
		return list;
	}


//按id查询精选菜
	
	public Map<String,Object> findimgByid(int id){
		String sql="select m.m_id,m.d_id,m.m_name,m.m_image,m.m_price,m.m_description,d.d_type from menu m left join dishes d on m.d_id=d.d_id where m_id=?";
		Connection conn=DBConnection.getConnection();
		ResultSet rs=null;
		Map<String,Object> map = null;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs=ps.executeQuery();
			if(rs.next()){
			    map=new HashMap<String,Object>();
				map.put("id", rs.getInt(1));
				map.put("m_name", rs.getString(3));
				map.put("m_image", rs.getString(4));
				map.put("price", rs.getString(5));
				map.put("tecont", rs.getString(6));
				map.put("d_type", rs.getString(7));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return map;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//添加
	public int addimg(JingxuanMenuBean img){
		String sql="insert into jxmenu values(null,?,?,?,?,?)";
		Connection conn=DBConnection.getConnection();
		int i=0;
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, img.getM_name());
			ps.setString(2, img.getFname());
			ps.setFloat(3, img.getPrice());
			ps.setString(4, img.getTecont());
			ps.setInt(5, img.getType_id().getD_id());
			i=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return i;
	}

	//查询
	public List<Map<String,Object>> findimg(){
		String sql="select m.id,m.m_name,m.fname,m.price,m.tecont,d.d_type from jxmenu m inner join dishes d on m.mm_id=d.d_id ";
		Connection conn=DBConnection.getConnection();
		ResultSet rs=null;
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		try {
			PreparedStatement ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()){
				Map<String,Object> map=new HashMap<String,Object>();
				map.put("id", rs.getInt(1));
				map.put("m_name", rs.getString(2));
				map.put("m_fname", rs.getString(3));
				map.put("price", rs.getString(4));
				map.put("tecont", rs.getString(5));
				Dishes dd=new Dishes();
				dd.setD_type(rs.getString(6));
				map.put("d_type", dd.getD_type());
				list.add(map);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	//查询测试方法
	public static void main(String[] args) {
		JingxuanMenuDao dao=new JingxuanMenuDao();
		List<Map<String,Object>> list=dao.findimg();
		String json=GsonUtil.toJson(list);
	/*	response.setContentType("html/text;charset=utf-8"); //设置响应格式
		response.getWriter().println(json);  //响应输出
*/		System.out.println(json);
	}
	
	//删除
	public int[] removeJingxuan(int[] ids){
		Connection conn=null;
		PreparedStatement ps=null;
		int[] rows=null;
		String sql="update menu set jx =0 where m_id=?";
		try{
			conn=DBConnection.getConnection();
			//设置自动提交为手动提交
			conn.setAutoCommit(false);
			ps=conn.prepareStatement(sql);
			for (int bid : ids) {
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
			DBConnection.close(null, ps, conn);
		}
		return rows;
	}

	
	//移除精选菜
	public int remove(Menu m) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="update menu set jx=0 where m_id=?"; 
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, m.getM_id());
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}finally {
			DBConnection.close(null, ps, conn);
		}
		return n;
	}

	
	/**
	 * 
	 * 添加精选菜
	 * @param id
	 * @return
	 */
	public int uploat(int id) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="update menu set jx=1 where m_id=?";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, id);
			n=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		
		return n;
	}
}
