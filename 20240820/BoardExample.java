package day10;

import java.sql.SQLException;
import java.util.Scanner;

public class BoardExample {

    private Scanner scanner = new Scanner(System.in);
    static DataModel dm = null;
    static String loggedInUser = null;

    public BoardExample() {
        dm = new DataModel();
    }
    
    public void mainMenu() throws SQLException {
        System.out.println();
        System.out.println("-------------------------------------------------------");
        if (loggedInUser == null) {
            System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Login | 6.Exit");
        } else {
            System.out.println("메인 메뉴: 1.Create | 2.Read | 3.Clear | 4.Join | 5.Logout | 6.Exit");
        }
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();
        System.out.println();

        switch(menuNo) {
            case "1" : 
                dm.create();
                break;
            case "2" :
                dm.read();
                break;
            case "3" :
                dm.clear();
                break;
            case "4" :
                dm.join();
                break;
            case "5" :
                if (loggedInUser == null) {
                    login();
                } else {
                    logout();
                }
                break;
            case "6" :
                dm.exit();
                break;
        }
    }

    private void login() throws SQLException {
        System.out.println("[로그인]");
        System.out.print("아이디: ");
        String userId = scanner.nextLine();
        System.out.print("비밀번호: ");
        String password = scanner.nextLine();

        System.out.println("-------------------------------------------------------");
        System.out.println("보조 메뉴: 1.Ok | 2.Cancel");
        System.out.print("메뉴 선택: ");
        String menuNo = scanner.nextLine();

        if (menuNo.equals("1")) {
            if (dm.verifyLogin(userId, password)) {
                loggedInUser = userId;
                System.out.println("로그인 성공!");
            } else {
                System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
                login();  // 재시도
            }
        }
        dm.list();
    }

    private void logout() throws SQLException {
        loggedInUser = null;
        System.out.println("로그아웃 되었습니다.");
        dm.list();
    }
    
    public static void main(String[] args) throws SQLException {
        BoardExample boardExample = new BoardExample();
        while (true) {
            boardExample.mainMenu();
        }
    }
}