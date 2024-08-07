package day02;

public class GameExam {

	public static void main(String[] args) {
		/** 
		 * continue 문 활용 369 게임
		 * 1부터 10까지 정수 출력중 3, 4, 9 일때 박수출력
		 */
		
		for (int i = 1; i < 11; i++) {	

			if (i % 3 == 0) {
				System.out.print("짝 ");	
				continue;
			}			
			System.out.print( i + " ");
		}
		
	}

}
