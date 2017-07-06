package com.ms.msspace.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class JDBCUtil {
	// 第一：定义连接数据库的相关信息
		private static final String URL = "jdbc:sqlserver://localhost:1433;databasename=MS_space";
		private static final String NAME = "sa";
		private static final String PASS = "123456";
		private static Connection conn;

		// 第二：获取连接对象
		public static Connection getConnection() {

			try {
				// 1.加载驱动->反射
				Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
				// 2.获取连接对象
				conn = DriverManager.getConnection(URL, NAME, PASS);
			} catch (ClassNotFoundException e) {
				System.out.println("加载驱动失败!");
				e.printStackTrace();
			} catch (SQLException e) {
				System.out.println("获取连接对象失败");
				e.printStackTrace();
			}

			return conn;
		}

		// 第三：关闭连接对象
		public static void close(Connection conn, Statement stmt, ResultSet rst) {

			if (rst != null) {
				try {
					rst.close();
				} catch (SQLException e) {
					System.out.println("关闭结果集对象失败");
					e.printStackTrace();
				}
			}

			if (stmt != null) {
				try {
					stmt.close();
				} catch (SQLException e) {
					System.out.println("关闭语句对象失败");
					e.printStackTrace();
				}
			}

			if (conn != null) {
				try {
					conn.close();
				} catch (SQLException e) {
					System.out.println("关闭连接对象失败");
					e.printStackTrace();
				}
			}

		}

		 public static void main(String[] args) {
			 System.out.println(JDBCUtil.getConnection());
		 }
}
