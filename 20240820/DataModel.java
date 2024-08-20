package day10;

import java.sql.*;
import java.util.Scanner;

public class DataModel {
// 1. 데이터 베이스 연결
// 2. 데이터 입출력 담당 메소드 구현
	
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;
	ConnectDB cdb = null;
	Board board = null;
	User user = null;
	static Scanner scan = null;
	static BoardExample be = new BoardExample();
	public DataModel() {
		cdb = new ConnectDB(); // DB연결
		con = cdb.getCon();
		if (con != null) {
			System.out.println("연결 성공");
		}else {
			System.out.println("연결 실패");
		}
		scan = new Scanner(System.in);
	} //생성자------------
	
	//데이터 추가 메소드 (insert into~)
	public void insertData(Board board) throws SQLException{
		int num =0;
		this.board = board;
		String sql = "INSERT INTO boards(btitle, bcontent, bwriter, bdate) VALUES (?, ?, ?,now())";
		
		pst = con.prepareStatement(sql);
		pst.setString(1, board.getBtitle());
		pst.setString(2, board.getBcontent());
		pst.setString(3, board.getBwriter());
		
		num = pst.executeUpdate();
		if (num > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
	}
	public void insertUsers(User user) throws SQLException {
		int num1 = 0;
		this.user = user;
		String sql1 = "INSERT INTO users(userid, username, userpassword, userage, useremail) VALUES (?, ?, ?, ?, ?))";
		pst = con.prepareStatement(sql1);
		pst.setString(1, user.getUserId());
		pst.setString(2, user.getUserName());
		pst.setString(3, user.getUserPassword());
		pst.setInt(4, user.getUserAge());
		pst.setString(5, user.getUserEmail());
		
		num1 = pst.executeUpdate();
		if (num1 > 0) {
			System.out.println("저장 성공");
		} else {
			System.out.println("저장 실패");
		}
	}
	
	public void create() throws SQLException {
		Board board = new Board();
		System.out.println("[새 게시물 입력]");
		System.out.print("제목 : ");
		board.setBtitle(scan.nextLine());
		System.out.print("내용 : ");
		board.setBcontent(scan.nextLine());
		System.out.print("작성자 : ");
		board.setBwriter(scan.nextLine());

		System.out.println("-------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		if(menuNo.equals("1")) {
		//boards 테이블에 게시물 정보 저장
			try {
				String sql = "" +
						"INSERT INTO boards (btitle, bcontent, bwriter, bdate) " +
						"VALUES (?, ?, ?, now())";
				PreparedStatement pstmt = con.prepareStatement(sql);
				pstmt.setString(1, board.getBtitle());
				pstmt.setString(2, board.getBcontent());
				pstmt.setString(3, board.getBwriter());
				pstmt.executeUpdate();
				pstmt.close();
				} catch (Exception e) {
					e.printStackTrace();
					exit();
				}
		}
		list();
	}
	
	public boolean verifyLogin(String userId, String password) throws SQLException {
	        String sql = "SELECT userpassword FROM users WHERE userid = ?";
	        try (PreparedStatement pstmt = con.prepareStatement(sql)) {
	            pstmt.setString(1, userId);
	            try (ResultSet rs = pstmt.executeQuery()) {
	                if (rs.next()) {
	                    String storedPassword = rs.getString("userpassword");
	                    return password.equals(storedPassword);
	                }
	            }
	        }
	        return false;
	 }
	  
	public void list() throws SQLException {
		System.out.println();
        System.out.println("[게시물 목록]" + (BoardExample.loggedInUser != null ? " 사용자: " + BoardExample.loggedInUser : ""));
        System.out.println("---------------------------------------------------------");
        System.out.printf("%-6s%-10s%-16s%-40s\n", "no", "writer", "   date", "   title");
        System.out.println("---------------------------------------------------------");
    
        try {
            String sql = "" +
                "SELECT bno, btitle, bcontent, bwriter, bdate " +
                "FROM boards " +
                "ORDER BY bno DESC";
            PreparedStatement pstmt = con.prepareStatement(sql);
            rs = pstmt.executeQuery();
            while(rs.next()) {
                Board board = new Board();
                board.setBno(rs.getInt("bno"));
                board.setBtitle(rs.getString("btitle"));
                board.setBcontent(rs.getString("bcontent"));
                board.setBwriter(rs.getString("bwriter"));
                board.setBdate(rs.getDate("bdate"));
                System.out.printf("%-6d%-10s%-16s%-40s \n",
                        board.getBno(),
                        board.getBwriter(),
                        board.getBdate(),
                        board.getBtitle());
            }
            rs.close();
            pstmt.close();
        } catch(SQLException e) {
            e.printStackTrace();
            exit();
        }
        be.mainMenu();
    }
	
	public void delete()	 {
		
		System.out.print("삭제할 게시물 번호를 입력하세요: ");	
        int bno = Integer.parseInt(scan.nextLine());
        
		try {
			String sql = "DELETE FROM boards WHERE bno=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			int result = pstmt.executeUpdate();
            pstmt.close();
            if (result > 0) {
                System.out.println("게시물이 성공적으로 삭제되었습니다.");
            } else {
                System.out.println("삭제할 게시물을 찾을 수 없습니다.");
            }
		}catch (SQLException e) {
			e.printStackTrace();
			exit();
		}
	}
	
	public void read() throws SQLException {
		
		System.out.println("[게시물 읽기]");
		System.out.print("bno: ");
		int bno = Integer.parseInt(scan.nextLine());
		
		try {
			String sql = "" +
					"SELECT bno, btitle, bcontent, bwriter, bdate " +
					"FROM boards " +
					"WHERE bno =?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bno);
			ResultSet rs = pstmt.executeQuery();
			if(rs.next()) {
				Board board = new Board();
				board.setBno(rs.getInt("bno"));
				board.setBtitle(rs.getString("btitle"));
				board.setBcontent(rs.getString("bcontent"));
				board.setBwriter(rs.getString("bwriter"));
				board.setBdate(rs.getDate("bdate"));
				System.out.println("#############");
				System.out.println("번호: " + board.getBno());
				System.out.println("제목: " + board.getBtitle());
				System.out.println("내용: " + board.getBcontent());
				System.out.println("작성자: " + board.getBwriter());
				System.out.println("날짜: " + board.getBdate());
				System.out.println("----------------------");
				System.out.println("보조 메뉴: 1.Update | 2.Delete | 3.List");
				System.out.print("메뉴 선택: ");
				String menuNo = scan.nextLine();
				System.out.println();
				
				if(menuNo.equals("1")) {
					update(board);
					} else if(menuNo.equals("2")) {
					delete();
					}
				} else {
					System.out.println("없는 번호입니다.");
				}
			rs.close();
			pstmt.close();
		}catch (Exception e) {
			e.printStackTrace();
			exit();
		}
		list();
	}
	public void clear() throws SQLException {
		System.out.println("[게시물 전체 삭제]");
		System.out.println("-------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		if(menuNo.equals("1")) {
		//boards 테이블에 게시물 정보 전체 삭제
		try {
		String sql = "TRUNCATE TABLE boards";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.executeUpdate();
		pstmt.close();
		} catch (Exception e) {
		e.printStackTrace();
		exit();
			}
		}

		list();
	}
	public void update(Board board) throws SQLException {
		//수정 내용 입력 받기
		System.out.println("[수정 내용 입력]");
		System.out.print("제목: ");
		board.setBtitle(scan.nextLine());
		System.out.print("내용: ");
		board.setBcontent(scan.nextLine());
		System.out.print("작성자: ");
		board.setBwriter(scan.nextLine());
		//보조 메뉴 출력
		System.out.println("------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		if(menuNo.equals("1")) {
		//boards 테이블에서 게시물 정보 수정
		try {
		String sql = "" +
		"UPDATE boards SET btitle=?, bcontent=?, bwriter=? " +
		"WHERE bno=?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, board.getBtitle());
		pstmt.setString(2, board.getBcontent());
		pstmt.setString(3, board.getBwriter());
		pstmt.setInt(4, board.getBno());
		pstmt.executeUpdate();
		pstmt.close();
		} catch (Exception e) {
		e.printStackTrace();
		exit();
		}
	}
		list();
}	
	public void exit() {
		if(con != null) {
		try {
		con.close();
		} catch (SQLException e) {
	}
		}
		System.out.println("** 게시판 종료 **");
		System.exit(0);
	}
	
	public void join() throws SQLException {
		User user = new User();
		System.out.println("[새 사용자 입력]");
		System.out.print("아이디 : ");
		user.setUserId(scan.nextLine());
		System.out.print("이름 : ");
		user.setUserName(scan.nextLine());
		System.out.print("비밀번호 : ");
		user.setUserPassword(scan.nextLine());
		System.out.print("나이 : ");
		user.setUserAge(Integer.parseInt(scan.nextLine()));
		System.out.print("이메일 : ");
		user.setUserEmail(scan.nextLine());
		
		System.out.println("-------------------------------------------------------");
		System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
		System.out.print("메뉴 선택: ");
		String menuNo = scan.nextLine();
		if (menuNo.equals("1")) {
		try {
			String sql1 = ""+ 
					"INSERT INTO users(userid, username, userpassword, userage, useremail) " +
					"VALUES (?, ?, ?, ?, ?)";
			PreparedStatement pstmt = con.prepareStatement(sql1);
			pstmt.setString(1, user.getUserId());
			pstmt.setString(2, user.getUserName());
			pstmt.setString(3, user.getUserPassword());
			pstmt.setInt(4, user.getUserAge());
			pstmt.setString(5, user.getUserEmail());
			pstmt.executeUpdate();
			pstmt.close();
			} catch (Exception e) {
				e.printStackTrace();
				exit();
			}
		}
		list();
	}
}
//	public static void main(String[] args) throws SQLException {
//		DataModel dm = new DataModel();
//		String selnum = null;
//		scan = new Scanner(System.in);
//		while (true) {
//            System.out.println("\n[1] 입력, [2] 조회, [3] 삭제, [4] 종료");
//            System.out.print("입력: ");
//            selnum = scan.nextLine();
//            
//            switch (selnum) {
//                case "1":
//                    dm.create();
//                    break;
//                case "2":
//                    dm.list();
//                    break;
//                case "3":
//                    dm.delete();
//                    break;
//                case "4":
//                    System.out.println("프로그램을 종료합니다.");
//                    return;
//                default:
//                    System.out.println("잘못된 입력입니다. 다시 선택해주세요.");
//            }
//		}
//	}

