package day09;

import java.sql.*;

public class DBTest2 {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt	= null;
		ResultSet rs = null;
		try {
			//1. JDBC 드라이버 로딩....
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//2. 데이터 베이스 연결....
			String url = "jdbc:mysql://localhost:3306/contacts";
			String id = "root";
			String pwd = "1234";
			
			conn = DriverManager.getConnection(url, id, pwd);
			
			System.out.println("연결 성공");
			
	//		3. sql 실행하기 위한 Statement, PreparedStatement 객체 생성
	//		String sql = "INSERT INTO person (name, phone, email) VALUES ('가나다', '010-1211-1111', 'skm@email.com')";
	        
			
			String sql2 = "select name, phone from person ";
			
			String sql3 = "select * from person where name = '홍길동'";
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql3);
			
			while(rs.next()) {
				String name = rs.getString("name");
				String phone = rs.getString("phone");
				String email = rs.getString("email");
				
				System.out.println("이름 : " + name);
				System.out.println("전화번호 : " + phone);
				System.out.println("이메일 : " + email);
			}
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					//연결끊기
					conn.close();
					rs.close();
					stmt.close();
					
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
	}
}
