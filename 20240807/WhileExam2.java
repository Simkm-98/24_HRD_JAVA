package day02;

public class WhileExam2 {

	public static void main(String[] args) {
		// 0 부터 100 까지 짝수들의 총합 계산
		int sum = 0;
		// while 문
		int i = 0; // 초기식
		while (i<101) { // 조건식
			i++;//증감식
			if(i % 2 == 0) {
				sum = i + sum;
			}
		}
		
		
		System.out.println("총 합 : " + sum);
	}
}
