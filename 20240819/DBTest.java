package day09;

import java.sql.*;

public class DBTest {

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
	        
			String sql2 = "insert into person (name, phone, email) values "
					+ "(?, ?, ?) ";
			PreparedStatement st = conn.prepareStatement(sql2);
			st.setString(1, "심경민");
			st.setString(2, "010-0000-1234");
			st.setString(3, "com@com.com");
			int result = st.executeUpdate();
            if(result > 0) {
                System.out.println("데이터 삽입 성공: " + result + "행이 삽입되었습니다.");
            } else {
                System.out.println("데이터 삽입 실패");
            }
//			while(rs.next()) {   
//                String name = rs.getString("name");
//                String phone = rs.getString("phone");
//                String email = rs.getString("email");
//                
//              
//                // 결과 출력
//                System.out.print("이름: " + name);
//                System.out.print(",	전화번호: " + phone);
//                System.out.println(", 이메일: " + email);
//            }
			
		}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}catch (SQLException e) {
			e.printStackTrace();
		}finally {
			if(conn != null) {
				try {
					//연결끊기
					conn.close();
					System.out.println("연결 끊기");
				} catch (SQLException e) {}
			}
		}
	}
}
