package day02;

public class WhileExam1 {

	public static void main(String[] args) {
		// 20 부터 11까지 감소 출력 후 종료
		int num = 20;
		int i = 0;

		while (i != 10) { 
			i++;
			if (num == 11) {
				System.out.println(num--);
				System.out.println("종료");
				break;
			}
			System.out.println(num--);
			
		}		
	}
}
