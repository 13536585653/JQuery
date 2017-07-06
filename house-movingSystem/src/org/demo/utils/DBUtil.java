package org.demo.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
	private static String driver="com.microsoft.sqlserver.jdbc.SQLServerDriver";
	private static String url="jdbc:sqlserver://localhost:1433;DatabaseName=houseMovingSystem";
	private static String user="sa";
	private static String password="123";
	
	static {
		try{
			Class.forName(driver);
		}catch(ClassNotFoundException e){
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		Connection conn=null;
		try{
			conn=DriverManager.getConnection(url,user,password);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	
	public static void close(ResultSet rs,PreparedStatement pstm,Connection conn){
		try{
			if(rs !=null){
				rs.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			if(pstm!=null){
				pstm.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		
		try{
			if(conn!=null){
				conn.close();
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		System.out.println(getConnection());
	}
}
