package com.maqian.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class JdbcUtils {

	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	private static String driver;
	private static String url;
	private static String user;
	private static String password;
	
	static {
		Properties pro = new Properties();
		try {
			pro.load(JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties"));
			driver = pro.getProperty("driver");
			url = pro.getProperty("url");
			user = pro.getProperty("user");
			password = pro.getProperty("password");
			Class.forName(driver);
		} catch (IOException | ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	public static Connection getConn() throws SQLException{
		Connection conn = tl.get();
		if(conn==null){
			conn = DriverManager.getConnection(url, user, password);
			tl.set(conn);
		}
		return conn;
	}
	
	
	public static void closeConn(){
		Connection conn = tl.get();
		if(conn!=null){
			try {
				conn.close();
				tl.set(null);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
