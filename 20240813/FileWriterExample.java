package day06;
import java.io.*;

public class FileWriterExample{
	
	static FileWriter fw = null;
	static BufferedInputStream bis = null;
	static BufferedOutputStream bos = null;
	
	public static void main(String[] args) {
		try {
			
			// 1. 키보드로 부터 문자데이터를 읽어 와서 콘솔 출력하고 파일로도 출력하기
			bis = new BufferedInputStream(System.in);
	        bos = new BufferedOutputStream(System.out);
			
	        int data = 0;
//			System.out.println("메세지 : " + message);
	         while ((data = bis.read()) != -1) {
	                // 콘솔에 출력
	                bos.write(data);
	                bos.flush();
	            } 

//			fw = new FileWriter("file.txt");
//			fw.write("java");

		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.out.println("파일이 존재하지 않습니다.");
			
		}finally {
			try {
				bis.close();
				bos.close();
			} catch (IOException e) {
				e.printStackTrace();
			} 
		}
	}
}
