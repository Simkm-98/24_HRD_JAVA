package day09;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.*;

public class BoardSelectExample {

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
	        
		
			String sql = "select * from boards where btitle = ?";
			st = conn.prepareStatement(sql);
			st.setString(1, "눈사람");
			rs = st.executeQuery();
			
			while(rs.next()) {
				int bno = rs.getInt("bno");
				String btitle = rs.getString("btitle");
				String bcontent = rs.getString("bcontent");
				String bwriter = rs.getString("bwriter");
				Timestamp bdate = rs.getTimestamp("bdate");
				String bfilename = rs.getString("bfilename");
				Blob blob = rs.getBlob("bfiledata");
				InputStream is = blob.getBinaryStream();
				OutputStream os = new FileOutputStream("C:\\Users\\COMPUTER\\eclipse-workspace\\JavaOOP\\src\\snow.jpg");
				is.transferTo(os);
				
				
				System.out.println("번호 : " + bno);
				System.out.println("타이틀 : " + btitle);
				System.out.println("콘텐트 : " + bcontent);
				System.out.println("Writer : " + bwriter);
				System.out.println("날짜 : " + bdate);
				System.out.println("파일이름 : " + bfilename);
				System.out.println("파일데이터 : " + is);

				os.flush();		
				os.close();
				is.close();
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
