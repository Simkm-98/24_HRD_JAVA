package day01;
/*
 *  4칙 연산과 나머지 연산을 하는 간단한 계산기
 */

import java.util.Scanner;

public class VarTest5 {

	public static void main(String[] args) {
		double val1, val2 = 0;
		String type = " ";
		
		Scanner sc = new Scanner(System.in);
		
		// 1. 4칙 연산을 입력 받아 저장하는 변수 선언
		System.out.print("첫번째 수를 입력해주세요 : ");
		val1 = sc.nextDouble();
		
		System.out.print("두번째 수를 입력해주세요 : ");
		val2 = sc.nextDouble();
		
		// 2. 2개 정수 입력받아 저장하는 변수 선언
		double result = 0.0;
		
		// 3. "+" 덧셈, "-" 뺄셈, "*" 곱셈, "/" 나눗셈, "%" 나머지 연산 
		System.out.print("원하는 연산을 입력해주세요 : ");	
		type = sc.next();
		
		if (type.equals("+")) {
			result = val1 + val2;
		}else if (type.equals("-")) {
			result = val1 - val2;
		}else if (type.equals("*")) {
			result = val1 * val2;
		}else if (type.equals("/")) {
			result = val1 / val2;
		}else if (type.equals("%")) {
			result = val1 % val2;
		}else 
			System.out.println("지원하지 않는 연산입니다.");
		
		System.out.println("결과 : " + val1 +" "+ type +" "+ val2 + " = " + result);
	}

}
