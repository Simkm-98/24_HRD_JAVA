package day02;
import java.util.Random;
import java.util.Scanner;
public class RandomExam2 {

	public static void main(String[] args) {
		// 1. 가위, 2. 바위, 3. 보 (가위바위보 게임)
		Scanner sc = new Scanner(System.in);
		Random ran = new Random();
		
		String value = "";
		String value2 = "";
		int num = 0;
		int a = 0;
		int user = 0;
		
		System.out.println("가위, 바위, 보 게임");
		
		do {
			System.out.print("선택 : ");
			value = sc.nextLine();
			if (value.equals("가위")) {
				user = 1;
			} else if (value.equals("바위")) {
				user = 2;
			} else if (value.equals("보")) {
				user = 3;
			} else if (value.equals("q")) {
				user = 4;
				break;
			} else 
				user = 5;
				
			num = ran.nextInt(3)+1;
			if (num == 1) {
				value2 = "가위";
			}else if (num == 2) {
				value2 = "바위";
			}else if (num == 3) {
				value2 = "보";
			}
			
			if (user == num) {
				System.out.println("비겼습니다. ## 나 : "+ value + ", 컴퓨터 : " + value2 + " ##");
				} else if ((user == 1) && (num == 3) || 
						(user == 2) && (num == 1) ||
						(user == 3) && (num == 2)) {
					System.out.println("이겼습니다. ## 나 : "+ value + ", 컴퓨터 : " + value2 + " ##");
				}else if ((user == 1) && (num == 2) || 
						(user == 2) && (num == 3) ||
						(user == 3) && (num == 1)){
					System.out.println("졌습니다. ## 나 : "+ value + ", 컴퓨터 : " + value2 + " ##");
				}else 
					System.out.println("가위, 바위, 보 중에서 내주세요");
			
		} while (user != 4);						
		
		System.out.println("프로그램 종료");
	}
}
