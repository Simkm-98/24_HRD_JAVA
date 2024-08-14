package day07;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoClient {
	private static boolean isRunning = true;
	
	public static void main(String[] args) {

		 try {
	            Socket socket = new Socket("localhost", 50001);
	            System.out.println("[클라이언트] 연결 성공");
	            
	            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
	            DataInputStream dis = new DataInputStream(socket.getInputStream());
	            
	            // 서버로부터 메시지를 받는 스레드
	            Thread receiveThread = new Thread(() -> {
	                try {
	                    while (isRunning) {
	                        String message = dis.readUTF();
	                        System.out.println("서버: " + message);
	                        System.out.print("대화: ");

	                    }
	                } catch (IOException e) {
	                    System.out.println("[클라이언트] 서버 연결 종료");
	                }
	            });
	            receiveThread.start();

	            // 메인 스레드에서 메시지 입력 및 전송
	            Scanner scanner = new Scanner(System.in);
	            while (isRunning) {
	                String message = scanner.nextLine();
	                if (message.equalsIgnoreCase("quit")) {
	                    isRunning = false;
	                    break;
	                }
	                dos.writeUTF(message);
	                dos.flush();
	            }
	            scanner.close();
	            socket.close();
	        } catch (IOException e) {    
	            e.printStackTrace();
	        }
	}
}
