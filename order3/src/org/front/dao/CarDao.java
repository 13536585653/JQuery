package org.front.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.order.bean.Menu;
import org.order.bean.MyCat;
import org.order.utils.DBConnection;

public class CarDao {

	
	/***
	 * 
	 * 
	 * 检查该用户的购物车是否已存在该商品
	 * @param c
	 * @return
	 */
	public int check(MyCat c) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		int n=0;
		String sql="select * from  car where c_mid=? and  c_uid=? ";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, c.getC_mid());
			ps.setInt(2, c.getC_uid());
			rs=ps.executeQuery();
			if(rs.next()){
				n=1;
				return n;
			}
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return 0;
	}

	
	/**
	 * 
	 * 修改数量
	 * @param c
	 */
	public int updatecar(MyCat c) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="update    car set c_num=c_num+?  where c_uid=? ";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, c.getNum());
			ps.setInt(2, c.getC_uid());
			n=ps.executeUpdate();

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}

	/**
	 * 
	 * 添加
	 * @param c
	 * @return
	 */
	public int addcar(MyCat c) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		int n=0;
		String sql="insert into car values(null,?,?,?)";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, c.getC_uid());
			ps.setInt(2, c.getC_mid());
			ps.setInt(3, c.getNum());
			n=ps.executeUpdate();

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return n;
	}


	
	/**
	 * 
	 * 查询所有
	 * @param c
	 * @return
	 */
	public List<MyCat> selectcar(MyCat c) {
		Connection conn=DBConnection.getConnection();
		PreparedStatement ps=null;
		ResultSet rs=null;
		List<MyCat> list=new ArrayList<MyCat>();
		String sql="select  * from  car c inner join  menu  m on c.c_mid=m.m_id where c_uid=? ";
		try {
			ps=conn.prepareStatement(sql);
			ps.setInt(1, c.getC_uid());
			rs=ps.executeQuery();
			while(rs.next()){
				MyCat  car=new MyCat();
				car.setC_id(rs.getInt(1));
				car.setC_uid(rs.getInt(2));
				car.setNum(rs.getInt(4));
				Menu m=new Menu();
				m.setM_id(rs.getInt(5));
				m.setM_name(rs.getString(6));
				m.setM_price(rs.getFloat(7));
				m.setM_img(rs.getString(8));
				m.setM_description(rs.getString(9));
				car.setMenu(m);
				list.add(car);
				
			}

		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		return list;
	}


	/**
	 * 
	 * 
	 * 结算完成 删除购物车的商品
	 * @param cid
	 */
	public int delete(int cid,int userid) {
		Connection conn=DBConnection.getConnection();
	PreparedStatement ps=null;
	int n=0;
	String sql="delete from car where c_id=? and c_uid=?";
	try {
		ps=conn.prepareStatement(sql);
		ps.setInt(1, cid);
		ps.setInt(2, userid);
		n=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO 自动生成的 catch 块
		e.printStackTrace();
	}
	return n;
		
	}

}
