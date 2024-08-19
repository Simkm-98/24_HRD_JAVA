package day09;

import java.io.FileInputStream;
import java.sql.*;

public class UserSelectExample {

	public static void main(String[] args) {
		Connection conn = null;
		Statement stmt	= null;
		ResultSet rs = null;
		PreparedStatement st = null;
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
	        
		
			String sql = "select * from users where userid =?";
			st = conn.prepareStatement(sql);
			st.setString(1, "winter");
			rs = st.executeQuery();
			
			while(rs.next()) {
				String userid = rs.getString("userid");
				String username = rs.getString("username");
				String userpassword = rs.getString("userpassword");
				int userage = rs.getInt("userage");
				String useremail = rs.getString("useremail");
				
				System.out.println("아이디 : " + id);
				System.out.println("이름 : " + username);
				System.out.println("비밀번호 : " + userpassword);
				System.out.println("나이 : " + userage);
				System.out.println("이메일 : " + useremail);
			}
		
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					//연결끊기
					conn.close();
					st.close();
					rs.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
	}
}
