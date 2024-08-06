/*
 * 실행문은 변수 선언, 변수값 저장, 메소드 호출에 해당하는 코드
 * 실행문 끝에는 반드시 세미콜론 붙여 실행문의 끝 표시
 * 변수명은 단독 숫자 x, 특수문자 _ 만 가능
 */

package day01;
import java.util.Scanner;

public class VarTest1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
					
		// 1. 정수 변수
		
		int x;
		x = 5; // 변수 초기화
		System.out.print("첫번째 정수 입력 : ");
		x = sc.nextInt();
		
		int y = 8;
		System.out.print("두번째 정수 입력 : ");
		y = sc.nextInt();
		
		int result = x + y;
		System.out.println("첫번째 정수 + 두번째 정수 : "+ result);
		
		// 2. 실수변수
		// float(4byte), double(8byte)
	
		double height = 155.7;
		System.out.print("몸무게 입력(소수점 첫자리) : ");
		height = sc.nextDouble();
		
		float weight = 45.5f;
		System.out.print("키 입력(소수점 첫자리) : ");
		weight = sc.nextFloat();

		System.out.println("키 : "+ height+ "\n몸무게 : " + weight);
		
		// 3. 문자형 변수
		//char (1byte) 값은 넣을 때 또는 한글자 작은 따옴표, 출력시엔 또는 여러 글자 큰 따옴표
		char blood = 'A';
		System.out.print("혈액형 입력 : ");
		blood = sc.next().charAt(0);
		
		System.out.println("혈액형 : " + blood);
		
		// 4. 문자열 변수
		// String 참조형변수 선언도 가능(S 대문자)
		String name = "심경민";
		System.out.print("이름입력:");
		name = sc.next();
		
		String classNum = "20171376";
		System.out.print("학번입력:");
		classNum = sc.next();
		
		System.out.println("이름 : " + name + "\n학번 : " + classNum + " 입니다.");
		
		// 5. 논리형 변수
		// boolean 형 (소문자)
		boolean stop = true;
		System.out.print("true and false? : ");
		
		stop = sc.nextBoolean();
		
		if (stop == true) {
			System.out.println("중지합니다.");		
			
		}else {
			System.out.println("시작합니다.");
			
		}
		
	}

}
