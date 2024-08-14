package day07;
import java.io.*;
public class InputStreamTest {

	public static void main(String[] args) {
		try {
			int r =0;
			int count = 0;
			while(true) {
				r = System.in.read();
				count++;
				if(r=='x' || r=='X') break;
				System.out.println("r = " + (char)r);
				
//				"r = 13": Enter 키의 ASCII 코드 값은 13 (캐리지 리턴).
//				"r = 10": 줄바꿈(Line Feed)의 ASCII 코드 값은 10
				
			} // while---------------------------
			System.out.println("******************");
			System.out.println(count + "bytes 읽음");
			System.out.println("******************");
			System.in.close();
			}catch(IOException e) {
				e.getMessage();
			}
	}
}
