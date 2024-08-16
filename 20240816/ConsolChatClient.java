package day08;

import java.net.*;
import java.io.*;

public class ConsolChatClient implements Runnable {

		public Socket sock = null;
		
	public ConsolChatClient() {
		
		
		try {
			sock = new Socket("192.168.0.3", 50001);
			System.out.println("서버와 연결 성공");
			BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
			PrintWriter pout = new PrintWriter(sock.getOutputStream(),true);
			
			Thread thread = new Thread(this);
			thread.start();
			
			String msg="";
			while((msg = key.readLine())!=null) {
				pout.println(msg);
			}
		}catch(IOException e) {
			 System.out.println("서버 연결 실패: " + e.getMessage());
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			new ConsolChatClient();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			InputStream is = sock.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(is));
			String serverMsg = "";
			while(true) {
				serverMsg = br.readLine();
				System.out.println("From Server: " + serverMsg);
			}
		}catch (Exception e) {
			System.out.println("예외: " + e.getMessage());
		}
	}

}
