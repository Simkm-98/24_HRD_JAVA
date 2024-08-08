package day03;

public class Person {
	// 객체 모델링 (클래스 멤버)
	
	// 속성 : has -a (person는 ~ age, name 등등 가진다)
	int age; // -
	String name; // - Person class 의 멤버 변수
	
	// 기본 생성자 
	public Person() {
		
	}
	// 메소드 (동작)
	void 웃다() {
		System.out.println("웃는다");
	}
	void 먹다() {
		System.out.println("먹는다");
	}
	
	int 더한다 (int a, int b) {
		int result = a + b;
		return result;
	}
	
}
