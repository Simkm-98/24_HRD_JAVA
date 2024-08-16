package day08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class MultiServer {
	ServerSocket ser;
    public ArrayList<MultiServerRunnable> arrlist;
    
    public MultiServer() {
        try {
            ser = new ServerSocket(5000);  // Changed to port 5000 to match client
            arrlist = new ArrayList<MultiServerRunnable>();
            System.out.println("서버 대기중...");
            
            while(true) {
                Socket socket = ser.accept();
                System.out.println("연결 성공");
                MultiServerRunnable mr = new MultiServerRunnable(socket);
                arrlist.add(mr);
                Thread thread = new Thread(mr);
                thread.start();         
            }
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        new MultiServer();
    }
	
	class MultiServerRunnable implements Runnable {
		Socket sock;
		DataInputStream dis;
		DataOutputStream dos;
		
		public MultiServerRunnable(Socket sock) {
			this.sock = sock;
		}
		
		public void broadCasting(String msg) throws IOException {
			for (MultiServerRunnable mr : arrlist) {
				if(mr!=this) 	{
				System.out.println("Message: " + msg.toString());
				mr.send(msg);
				}
			}
		}
		
		public void send(String msg) throws IOException {
			System.out.println("send[Message]: " + msg);
			dos.writeUTF(msg);
			dos.flush();
		}
		
		@Override
		public synchronized void run() {
			boolean flag = false;
			try {
				dis = new DataInputStream(sock.getInputStream());
				dos = new DataOutputStream(sock.getOutputStream());
			
				while(!flag) {
					String msg = dis.readUTF().toString();
					System.out.println("Message: " + msg);
					broadCasting(msg);
				}
			}catch(Exception e) {
		
			}
		}
	}
}
