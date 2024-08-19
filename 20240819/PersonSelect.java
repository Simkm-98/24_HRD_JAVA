package day09;

import java.sql.*;
import java.util.ArrayList;

public class PersonSelect {

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
	        
			

			String sql3 = "select * from person";
			
			
			stmt = conn.createStatement();
			
			rs = stmt.executeQuery(sql3);
			String name = "";
			String phone = "";
			String email = "";
			ArrayList<Person> arlist = new ArrayList<Person>();
			Person person = null;
			while(rs.next()) {
				name = rs.getString("name");
				phone = rs.getString("phone");
				email = rs.getString("email");
				person = new Person(name, phone, email);
				arlist.add(person);
			}
			for(Person p : arlist) {
				System.out.println(p.getName());
				System.out.println(p.getPhone());
				System.out.println(p.getEmail());
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
