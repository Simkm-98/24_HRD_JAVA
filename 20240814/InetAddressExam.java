package day07;

import java.io.IOException;
import java.net.InetAddress;

public class InetAddressExam {

	public static void main(String[] args) {
		try {
			InetAddress local = InetAddress.getLocalHost();
			System.out.println("내 컴퓨터 IP주소: " + local);
			InetAddress[] iaArr = InetAddress.getAllByName("www.dju.ac.kr");
			for(InetAddress remote : iaArr) {
				System.out.println("www.dju.ac.kr IP 주소: " + remote.getHostAddress());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
	}

}
