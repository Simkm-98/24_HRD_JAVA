package day02;

public class ForExam2 {

	public static void main(String[] args) {
		// 0 부터 100 까지 짝수들의 총합 계산
		int sum = 0;
		// for 문
		for(int i = 0; i < 101; i++) {
			if (i % 2 == 0) {
				sum = i + sum;
			}
		}

		
		
		System.out.println("총 합 : " + sum);
	}
}
