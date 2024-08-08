package day03;
import java.util.Scanner;
public class StudentScoresExam {

	public static void main(String[] args) {
		// 학생들의 점수를 분석하는 프로그램 실습
		// 5장 확인문제 9번 문제
		
		Scanner sc = new Scanner(System.in);
		
		int selNum = 0;
		int selStuNum = 0;
		int[] stuNum = null;
		System.out.println("-----------------------------------------------------------");
		System.out.println("1. 학생수 | 2. 점수입력 | 3. 점수리스트 | 4. 분석 | 5. 종료");
		System.out.println("-----------------------------------------------------------");
		while (selNum != 5) {
		
		System.out.print("선택> ");
		selNum = sc.nextInt();
		switch (selNum) {
		case 1 :
					System.out.print("학생수> ");
					selStuNum = sc.nextInt();
					stuNum = new int[selStuNum];
					break;
		case 2 : 
					System.out.println("점수입력> ");
					for (int i = 0; i<stuNum.length;i++) {
						stuNum[i] = sc.nextInt();
					}
					break;
		case 3 : 
					System.out.print("점수리스트 : \n");
					for(int j = 0; j<stuNum.length; j++) {
						System.out.println("학생 [" +(j + 1) + "] : " + stuNum[j]);
					}
					break;
		case 4 :
					System.out.println("점수 분석 : ");
					int max = 0;
					for (int m = 0; m<stuNum.length; m++) {
						if (stuNum[m] > max) {
							max = stuNum[m];
						}
					}
					System.out.println("최고 점수 : " + max);
					
					int sum = 0;
					double avg = 0;
					for (int a = 0; a<stuNum.length; a++) {
						sum += stuNum[a];
					}
					avg = sum / (double)selStuNum;
					System.out.println("평균 점수 : " + avg);
					break;
		}
		}
		System.out.println("프로그램 종료");
	}

}
