package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UR {
		private static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
		private static String url = "jdbc:sqlserver://localhost:1433;databaseName=sudoku";
		private static String uid = "sai";
		private static String pwd = "123456";
		static {
			try {
				Class.forName(driver);
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
		}
		public static Connection getCon() {
			Connection conn = null;
			try {
				conn = DriverManager.getConnection(url, uid, pwd);
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return conn;
		}
		public static int update(String sql) {
			int row = 0;
			Connection conn = getCon();
			Statement stmt = null;
			try {
				stmt = conn.createStatement();
				row = stmt.executeUpdate(sql);
			} catch (SQLException e) {
				e.printStackTrace();
			} finally {
				closeAll(null, stmt, conn);
			}
			return row;
		}
		public static void closeAll(ResultSet rs, Statement stmt, Connection conn){
			try {
				if(rs!=null)
					rs.close();
				if(stmt!=null)
					stmt.close();
				if(conn!=null)
					conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		public static void main(String[] args) throws SQLException {
			Connection conn = getCon();
			System.out.println(conn);
			conn.close();		
		}
}
