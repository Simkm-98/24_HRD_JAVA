package day02;
import java.util.Scanner;

public class DoWhileExam1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("메시지를 입력하세요.");
		System.out.println("프로그램을 종료하려면 q를 입력하세요");

		String val = "";
		
		do {
		val = sc.nextLine();
		System.out.println(">"+ val);
		
		} while(!val.equals("q"));
			
		System.out.println("프로그램 종료");
	}
}
