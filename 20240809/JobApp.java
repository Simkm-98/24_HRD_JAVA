package day04;
import java.util.ArrayList;
import java.util.Scanner;
import static java.lang.System.out;

import java.lang.reflect.Array;
public class JobApp {	

	static ArrayList<Person> arrList =  new ArrayList<>();

	public void showMenu(){
		out.println("***********JOB v1.1***********");
		out.println("** 1. 구직 등록 **");
		out.println("** 2. 구인 등록 **");
		out.println("** 3. 구직자 정보 출력 **");
		out.println("** 4. 구인회사 정보 출력 **");
		out.println("** 5. 종료 **");
		out.println("******************************");
		out.print(" 메뉴 번호를 입력하세요=>");
	}//showMenu()------------
	
	
	
	public static void inputPerson(){
		//이름,나이,성별,전화번호를 입력받아
		//Person객체에 저장
		Person p1 = new Person();
		Scanner sc=new Scanner(System.in);
		out.println("--구직 등록 start-------");
		out.print("이름 입력=>");
		String nm=sc.next();
		p1.name=nm;
		System.out.print("나이 입력=>");
		int a=sc.nextInt();
		p1.age=a;
		//성별, 전화번호 입력.....
		out.println("----성별 메뉴----");
		out.println(" 1.남자  2.여자 ");
		out.println("-----------------");
		out.print("성별 메뉴번호 입력=> ");
		int s=sc.nextInt();
		if(s==1)
			p1.gender='M';
		else if(s==2)
			p1.gender='F';
		else
			out.println("지원되지 않는 메뉴 번호입니다.");
		out.print("전화번호 입력=> ");
		String t=sc.next();
		p1.tel=t;
		
		arrList.add(p1);
	}

	void showInfo() {
		for(Person p : arrList) {
			p.getInfo();
		}
	}
	
	public static void main(String[] args) {
		
		// person 객체 생성
		
		Person hong = new Person();
		hong.age = 20;
		hong.name = "홍길동";
		Scanner sc=new Scanner(System.in);
		JobApp ja=new JobApp();
		while(true){
			ja.showMenu();
			int no=sc.nextInt();
			if(no==5){//종료
				out.println("프로그램 종료");
				System.exit(0);//프로그램 종료-0: 정상종료
			}else if(no==1){//1. 구직등록...
			//직장을 구하는 사람의 인적 정보를 입력받아야 한다.
			JobApp.inputPerson();
				//인적정보를 입력받는 모듈
			}else if(no==3) {
					ja.showInfo();	
			}
		}//while--------------
	}

}
