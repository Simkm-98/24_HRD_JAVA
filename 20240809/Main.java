package day04;

import java.util.ArrayList;

public class Main {
	
	
	// 클래스 구성 요소
	// 필드 : 객체의 데이터를 저장하는 역할은 한다.
	// 생성자 : 기본 생성자(선언 생략 가능), 인자 생성자(매개변수, 초기화를 위해)
	//   * 인자 생성자를 만들면 기본생성자 호출을 안함(인자 생성자를 만들거면 기본생성자 자동생성x 직접 만듬) *
	// 메소드 : 객체의 동작으로 호출 시 실행하는 블록
	
	public static void main(String[] args) {
			House ho1 = new House("심경민", 5, "대전대덕구오정동");
			ho1.showOwner(ho1.name);
			System.out.println(ho1.getRoomNum());
			System.out.println(ho1.showInfo());
			ho1.showInfo2();
			
			ArrayList<House> houses = new ArrayList<House>() ;
			houses.add(ho1);
			houses.add(new House("abc", 10, "대전동구용전동"));
			System.out.println(houses);
			System.out.println(houses.toString());
			for(House h : houses) {
				System.out.println("집주인 : " + h.name );
			}
	}

}

class House {
	String name;
	int roomNum;
	String address;
	
	public House() {
	
	}
	
	public House(String name, int roomNum, String address) {
		this.name = name;
		this.roomNum = roomNum;
		this.address = address;
	}
	
	void showOwner(String name) {
		System.out.println("주인 이름 : " + name);
	}
	
	int getRoomNum() {
		return roomNum;
	}
	
	String showInfo() {
		String result="집 주인 이름 : " + name + "\n방의 갯수 : " +roomNum+ "\n집 주소 : " + address;
		return result;
	}
	
	void showInfo2() {
		System.out.println("집 주인 이름 : " + name + "\n방의 갯수 : " +roomNum+ "\n집 주소 : " + address);
	}

	
	
	
}