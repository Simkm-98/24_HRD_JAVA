package day02;
import java.util.Scanner;

public class IfExam3 {

	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("## 로그인 (admin 혹은 임의아이디) ##");
		System.out.print("## 로그인 아이디 : ");
		String user = sc.next();
		if (user == "admin") {
			System.out.println("관리자 로그인!!");
		} else {
			System.out.println(user + " 로그인!!");
		}
		System.out.println("## 메뉴를 선택 하세요 (1~2) ## ");
		System.out.print("# 메뉴 선택 : ");
		num = sc.nextInt();
		if (user.equals("admin") && (num == 1 || num == 2)) {
			System.out.println("관리자 " + num + "번 선택함!!");
			
		} else if (!user.equals("admin") && num == 2) {
			System.out.println(user+ " " + num + "번 선택함!!");
			
		} else if (!user.equals("admin") && num == 1 ) {
			System.out.println(user+ " " + num + "번 선택함!!");
			
		} else 
			System.out.println("## 1 또는 2 를 선택해 주세요");
	} 
	
}	