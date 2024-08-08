package day03;

public class ArrayCreateByValueListExam1 {

	public static void main(String[] args) {
		// 2차원 배열
		String[] season = { "Spring", "Summer", "Fall", "Winter" };
		
		for (int i =0;i<season.length;i++) {
			System.out.println("season["+i+"] : " + season[i]);
		}
		season[1] = "여름";
		System.out.println("season[1] : " + season[1]);
		System.out.println();
		
	}
}
