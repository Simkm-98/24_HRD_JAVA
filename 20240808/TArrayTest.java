package day03;

public class TArrayTest {

	public static void main(String[] args) {
		  
		int[][][] scores = new int[3][2][5];
		    // 1학년
		    scores[0][0][0] = 85; scores[0][0][1] = 90; scores[0][0][2] = 75; scores[0][0][3] = 80; scores[0][0][4] = 95; // 1반
	        scores[0][1][0] = 70; scores[0][1][1] = 85; scores[0][1][2] = 90; scores[0][1][3] = 75; scores[0][1][4] = 80; // 2반

	        // 2학년
	        scores[1][0][0] = 88; scores[1][0][1] = 92; scores[1][0][2] = 78; scores[1][0][3] = 85; scores[1][0][4] = 90; // 1반
	        scores[1][1][0] = 72; scores[1][1][1] = 82; scores[1][1][2] = 95; scores[1][1][3] = 79; scores[1][1][4] = 88; // 2반

	        // 3학년
	        scores[2][0][0] = 91; scores[2][0][1] = 86; scores[2][0][2] = 84; scores[2][0][3] = 89; scores[2][0][4] = 93; // 1반
	        scores[2][1][0] = 76; scores[2][1][1] = 88; scores[2][1][2] = 94; scores[2][1][3] = 81; scores[2][1][4] = 87; // 2반

	        // 데이터 출력
	        for (int grade = 0; grade < scores.length; grade++) {
	            System.out.println((grade + 1) + "학년:");
	            for (int classNum = 0; classNum < scores[grade].length; classNum++) {
	                System.out.println("  " + (classNum + 1) + "반:");
	                for (int student = 0; student < scores[grade][classNum].length; student++) {
	                    System.out.println("    학생 " + (student + 1) + ": " + scores[grade][classNum][student] + "점");
	                }
	            }
	        }

	}

}
