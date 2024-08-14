package day07;

import java.io.*;

public class FileOutTest {

	public static void main(String[] args) {	
		
		System.out.print("파일로 저장할 내용을 입력하세요=> ");
		int n = 0;
		try {
			FileOutputStream fos = new FileOutputStream("test.txt", true);
			BufferedOutputStream bos = new BufferedOutputStream(fos);
			FileReader fr = new FileReader("test.txt");
			OutputStreamWriter osw = new OutputStreamWriter(System.out);
			while ((n = fr.read()) != -1) {
			
			osw.write(n);
			osw.flush();
			
			}
			fos.close();
			bos.close();
			fr.close();
			osw.close();
		
		}catch(FileNotFoundException f) {
			f.getMessage();
		}catch(IOException e) {
			e.getMessage();
		}
	}

}
