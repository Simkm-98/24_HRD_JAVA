package day03;

public class ArrayCreateByValueListExam3 {

	public static void main(String[] args) {
		// 2차원 배열
				int[][] scores = {
						{80, 90, 96},
						{76, 88}
				};
				
				System.out.println("1 차원 배열 길이(반의 수): " + scores.length);
				System.out.println("2 차원 배열 길이(첫 번째 반의 학생 수): " + scores[0].length);
				System.out.println("2 차원 배열 길이(두 번째 반의 학생 수): " + scores[1].length);
			
				System.out.println("scores[0][2]: " + scores[0][2]);
				System.out.println("scores[1][1]: " + scores[1][1]);
				
				int class1Sum = 0;
				for(int i=0; i<scores[0].length;i++) {
					class1Sum += scores[0][i];
				}
				double class1Avg = (double) class1Sum / scores[0].length;
				System.out.println("첫 번째 반의 평균 점수: " + class1Avg);
				
				int class2Sum = 0;
				for(int i =0; i<scores[1].length; i++) {
					class2Sum += scores[1][i];
				}
				double class2Avg = (double) class2Sum / scores[1].length;
				System.out.println("두 번째 반의 평균 점수: " + class2Avg);
				
				int totalStudent = 0;
				int totalSum = 0;
				for (int i=0; i<scores.length;i++) {
					totalStudent += scores[i].length;
					for(int k=0; k<scores[i].length;k++) {
						totalSum += scores[i][k];
					}
				}
				double totalAvg = (double) totalSum / totalStudent;
				System.out.println("전체 학생의 평균 점수: " + totalAvg);
				
				int[][][] ex = {
						{{ 1, 2, 3, 4, 5}, { 6, 7, 8, 9, 10},},
						{{ 11, 12, 13, 14, 15}, {16, 17, 18, 19, 20}} 
				};
				for (int i =0; i<ex.length;i++) {
					for (int j=0; j<ex[i].length;j++) {
						System.out.print(ex[i][j]+ " \n");
						for(int k =0; k<ex[i][j].length;k++) {
							System.out.print(ex[i][j][k] + " ");
						}
					}
						
				}
	}
}
