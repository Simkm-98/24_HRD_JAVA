package day03;

public class Member {
	String name;
	String id;
	String pw;
	int age;
	
	// 기본 생성자 선언 (생략가능)
	
	public Member() {
		
	}
	
	// 인자 생성자
	
	public Member(String name, String id) {		
		this.name =  name;
		this.id = id;
	}
	
}
