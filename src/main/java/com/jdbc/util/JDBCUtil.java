package com.jdbc.util;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtil {
	
	private static final String MYSQL_URI = "jdbc:mysql://localhost:3306/jdbccontainer";
	private static final String MYSQL_USERNAME ="root";
	private static final String MYSQL_PASSWORD = "ajay123";
	private static final String MYSQL_DRIVER_CLASS="com.mysql.cj.jdbc.Driver";
	
	private JDBCUtil() {
		System.out.println("Dont allow Object creation of this class-- outside, as this is going to be utility class---> all methods static");
	}

	public static Connection getConnection() {
		try {
			Class.forName(MYSQL_DRIVER_CLASS);
			Connection conn = DriverManager.getConnection(MYSQL_URI,MYSQL_USERNAME,MYSQL_PASSWORD);
			return conn;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return null;
	}
	
	
	public static void main(String[] args) {
		Connection conn = getConnection();
		System.out.println("Connection created -->" +conn);
	}
	/**
	 * Database Connectivity Steps
	 * 			1. Load the db drivers
	 * 			2. Create Connection
	 * 			3. Create Statement/pstmt
	 * 			4. execute query
	 * 			5. close resources
	 * 
	 * 
	 * @param conn
	 * @param st
	 * @param res
	 */
	//conn [ACK WITH DB] --state [ACTUAL COMMUNICATION CHANNEL [SQL QUERIES RUN]] --> result
	
	public static void closeResources(Connection conn,Statement st, ResultSet res) {
		if(res!=null) {
			try {
				res.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(st!=null) {
			try {
				st.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		if(conn!=null) {
			try {
				//conn.commit(); // to make changes --> final
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}

}


