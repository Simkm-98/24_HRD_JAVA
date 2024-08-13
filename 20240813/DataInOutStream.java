package day06;
import java.io.*;
	
public class DataInOutStream {
	
	static DataOutputStream dos = null;
	static DataInputStream dis	= null;
	
	
	public static void main(String[] args) {
		try {
			dos = new DataOutputStream(new FileOutputStream("data.txt"));
			dos.writeInt(10);
			dos.writeDouble(155.2);
			dos.writeBoolean(true);
			dos.writeChar('가');
			dos.writeUTF("문자열 입력하기");
			dos.flush();
			
			dis = new DataInputStream(new FileInputStream("data.txt"));
			System.out.println(dis.readInt());
			System.out.println(dis.readDouble());
			System.out.println(dis.readBoolean());
			System.out.println(dis.readChar());
			System.out.println(dis.readUTF());
			dos.close();
			dis.close();
		}catch(Exception e) {
			e.getMessage();
		}
	}
}
