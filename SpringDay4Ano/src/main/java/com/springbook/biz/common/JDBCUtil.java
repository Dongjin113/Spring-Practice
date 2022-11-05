package com.springbook.biz.common;

import java.sql.*;

public class JDBCUtil {
	Connection con = null;
	PreparedStatement stmt = null;
	ResultSet rs = null;
    
	/*
	String url = "jdbc:h2:tcp://localhost/./test";
	String userId = "sa";
	String pass = "1234";
	*/
	
	String url = "jdbc:oracle:thin:@//localhost:1521/xe";
	String userId = "system";
	String pass = "1234";
	
	private static JDBCUtil db = new JDBCUtil();
	
	private JDBCUtil() { }
	
	public static JDBCUtil getInstance() {
		return db;
	}
	
	public Connection getConnection() {
		try {
			// Class.forName("org.h2.Driver");
			Class.forName("oracle.jdbc.OracleDriver");
			con = DriverManager.getConnection(url, userId, pass);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

	public void close(PreparedStatement stmt, Connection con) {
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	public void close(ResultSet rs, PreparedStatement stmt, Connection con) {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
