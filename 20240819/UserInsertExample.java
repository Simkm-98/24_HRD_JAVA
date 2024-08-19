package day09;

import java.io.FileInputStream;
import java.sql.*;

public class UserInsertExample {

	public static void main(String[] args) {
		Connection conn = null;
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
	        
			String sql =  "" + "INSERT INTO boards (btitle, bcontent, bwriter, bdate, bfilename, bfiledata) " 
			                 + "VALUES (?, ?, ?, now(), ?, ?)" ;
			PreparedStatement pstmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			pstmt.setString(1, "눈 오는 날");
			pstmt.setString(2, "함박눈이 내려요.");
			pstmt.setString(3, "winter");
			pstmt.setString(4,"snow.jpg");
			pstmt.setBlob(5, new FileInputStream("C:\\Users\\COMPUTER\\eclipse-workspace\\JavaOOP\\src\\snow.jpg"));
			
			int rows = pstmt.executeUpdate();
			System.out.println("저장된 행 수: " + rows);
			
			if(rows == 1) {
				ResultSet rs = pstmt.getGeneratedKeys();
				if(rs.next()) {
					int bno = rs.getInt(1);
					System.out.println("저장된 bno: " + bno);
				}
				rs.close();
			}
			
//			int result = pstmt.executeUpdate();
//            if(result > 0) {
//                System.out.println("데이터 삽입 성공: " + result + "행이 삽입되었습니다.");
//            } else {
//                System.out.println("데이터 삽입 실패");
//            }
//            
//            int rows = pstmt.executeUpdate();
//            System.out.println("저장된 행의 수: " + rows);
//            pstmt.close();
            
            pstmt.close();
		}catch (Exception e) {
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
