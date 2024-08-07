package day02;
import java.util.Scanner;
public class ContiExam1 {
	public static void main(String[] args) {
	
		int i = 1;
		while(i<11) {
			i++;
			if (i % 2 != 0) {
				continue; // 아래로는 무시 다시 위로
			}

			System.out.print(" " + i);
		}
		
		
	}
	
}
