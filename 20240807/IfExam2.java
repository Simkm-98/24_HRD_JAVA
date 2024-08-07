package day02;
import java.util.Scanner;

public class IfExam2 {

	public static void main(String[] args) {
		int num = 0;
		Scanner sc = new Scanner(System.in);
		
		System.out.println("## 메뉴 선택 ##");
		System.out.println("[1] 구매자 [2] 판매자");
		System.out.print("## 메뉴를 선택 하세요 -> ");
		num = sc.nextInt();
		
		// if 문
		if(num == 1) {
			System.out.println("환영합니다! 구매자로 로그인하셨습니다.");
		} else if (num == 2) {
			System.out.println("환영합니다! 판매자로 로그인하셨습니다.");
		} else
			System.out.println("[1] 과 [2] 중 선택해주세요.");
		
		/* switch 문
		switch (num) {
		case 1 :
			System.out.println("환영합니다! 구매자로 로그인하셨습니다.");
			break;
		case 2 :
			System.out.println("환영합니다! 판매자로 로그인하셨습니다.");
			break;
		default :
			System.out.println("[1] 과 [2] 중 선택해주세요.");
		}*/

	} 
	
}	