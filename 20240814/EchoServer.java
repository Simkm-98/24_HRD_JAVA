package day07;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class EchoServer {
	private static ServerSocket serverSocket = null;
    private static Socket clientSocket = null;
	private static boolean isRunning = true;
	private static DataInputStream dis = null;
    private static DataOutputStream dos = null; 	
	public static void main(String[] args) {
		System.out.println("------------------------------------------------------------");    
        System.out.println("서버를 종료하려면 q 또는 Q를 입력하고 Enter 키를 입력하세요.");
        System.out.println("------------------------------------------------------------");
        
        try {
            serverSocket = new ServerSocket(50001);
            System.out.println("[서버] 시작됨");
            
            clientSocket = serverSocket.accept();
            System.out.println("[서버] 클라이언트 연결됨");
            
            dis = new DataInputStream(clientSocket.getInputStream());
            dos = new DataOutputStream(clientSocket.getOutputStream());

            // 클라이언트로부터 메시지를 받는 스레드
            Thread receiveThread = new Thread(() -> {
                try {
                    while (isRunning) {
                        String message = dis.readUTF();
                        System.out.println("클라이언트: " + message);
                        System.out.print("대화: ");

                    }
                } catch (IOException e) {
                    System.out.println("[서버] 클라이언트 연결 종료");
                }
            });
            receiveThread.start();

            // 메인 스레드에서 메시지 입력 및 전송
            Scanner scanner = new Scanner(System.in);
            while (isRunning) {
                String message = scanner.nextLine();
                if (message.equalsIgnoreCase("q")) {
                    isRunning = false;
                    break;
                }
                dos.writeUTF(message);
                dos.flush();
            }

            scanner.close();
            stopServer();

        } catch (IOException e) {
            System.out.println("[서버] " + e.getMessage());
        }
    }
	
	 public static void stopServer() {
	        try {
	            isRunning = false;
	            if (dis != null) dis.close();
	            if (dos != null) dos.close();
	            if (clientSocket != null) clientSocket.close();
	            if (serverSocket != null) serverSocket.close();
	            System.out.println("[서버] 종료됨 ");
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	    }
}
	// p.840 ex)
//	public static void startServer() {
//		Thread thread = new Thread() {
//			@Override
//			public void run() {
//				try {
//				serverSocket = new ServerSocket(50001);
//				System.out.println("[서버] 시작됨");
//				
//				while(true) {
//					System.out.println("\n[서버] 연결 요청을 기다림\n");
//					
//					Socket socket = serverSocket.accept();
//					
//					InetSocketAddress isa = 
//							(InetSocketAddress) socket.getRemoteSocketAddress();
//					System.out.println("[서버] " + isa.getHostString() + "의 연결 요청을 수락함");
//					
//					DataInputStream dis = new DataInputStream(socket.getInputStream());
//					String message = dis.readUTF();
//					
//					DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//					dos.writeUTF(message);
//					dos.flush();
//					System.out.println("[서버] 받은 데이터를 다시 보냄: " + message);
//					
//					socket.close();
//					System.out.println("[서버] " + isa.getHostString() + "의 연결을 끊음");
//					}
//				} catch(IOException e) {
//					System.out.println("[서버] " + e.getMessage());
//				}
//			}
//		};
//	
//		thread.start();
//
//		}			
//		public static void stopServer() {
//			try {
//				serverSocket.close();
//				System.out.println("[서버] 종료됨 ");
//			} catch (IOException e1) {}
//		}
//	
//	 private static void handleClient(Socket socket) {
//	        try (
//	            DataInputStream dis = new DataInputStream(socket.getInputStream());
//	            DataOutputStream dos = new DataOutputStream(socket.getOutputStream())
//	        ) {
//	            while (true) {
//	                String message = dis.readUTF();					// 데이터 읽어옴
//	                System.out.println("[서버] 메시지 받음: " + message);
//	                dos.writeUTF("\n서버: " + message);				// 데이터 씀
//	                dos.writeUTF("메세지 입력: ");
//	                dos.flush();
//	            }
//	        } catch (IOException e) {
//	            System.out.println("[서버] 클라이언트 연결 종료");
//	        }
//	    }
//}
