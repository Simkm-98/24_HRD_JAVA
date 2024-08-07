package day02;
import java.util.Random;
public class RandomExam {

	public static void main(String[] args) {
		//임의의 수를 생성과 수를 다루는 내장 객체 -> Random 클래스
		//참조형 변수 선언으로 생성한다.
		// 0.0 <= Random < 1
		Random random = new Random();
		int num = 0;
		int i = 0;
		// 1 ~ 45 번까지 수 5개 생성하기
		do {
		num = random.nextInt(45);
		System.out.println(num+1);
		i++;
		} while(i <6);
	}

}
