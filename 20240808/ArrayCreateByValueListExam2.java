package day03;

public class ArrayCreateByValueListExam2 {

	public static void main(String[] args) {
		String[] season = { "Spring", "Summer", "Fall", "Winter" };
		for (int i = 0; i<4; i++) {
			System.out.println("season[" + i + "] : " + season[i]);				
		}
		season[1] = "여름";
		System.out.println("season[1] : " + season[1]);
		System.out.println();
		
		int[] scores = { 83, 90, 87 };
		
		int sum = 0;
		for(int i =0; i<3; i++) {
			sum += scores[i];
		}
		
		System.out.println("총합 : " + sum);
		double avg = (double) sum / 3;
		System.out.println("평균 : " + avg);
		
		String[] name = new String[5];

		for (int j = 0; j<4; j++) {
			name[j] = "a";
			System.out.println(name[j]);
		}
		System.out.println(name[4]);
	}
}
