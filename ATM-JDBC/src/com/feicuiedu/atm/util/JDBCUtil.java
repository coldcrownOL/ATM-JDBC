package com.feicuiedu.atm.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCUtil {

	/**
	 * 链接数据库
	 * @param conn
	 * @return
	 */
	public static Connection util(Connection conn) {
		
		//驱动程序名
		String driver = "com.mysql.jdbc.Driver";
		
		//URL
		String url = "jdbc:mysql://localhost:3306/atm?useSSL=true";
		
		//用户名
		String user = "root";
		
		//密码
		String password = "123456";
		
		try {
			
			//加载驱动
			Class.forName(driver);
			
			//链接数据库
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return conn;
		
	}
	
}
