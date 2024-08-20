package day10;

import java.sql.*;
import java.util.concurrent.ExecutionException;
import java.io.*;

public class ConnectDB {

	static Connection con = null;
	
	public ConnectDB() {
		try {
			//1. JDBC 드라이버 로딩....
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. 데이터 베이스 연결....
			String url = "jdbc:mysql://localhost:3306/contacts";
			String id = "root";
			String pwd = "1234";
			
			con = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("연결 성공");
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e1) {
			e1.printStackTrace();
		}		
	} //ConnectDB 생성자-----------------------------------------------
	
	
	
	Connection getCon() {
		return con;
	}
}
