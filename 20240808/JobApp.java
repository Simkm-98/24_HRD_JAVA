package day03;

public class JobApp {

	public static void main(String[] args) {
		Person hong = new Person();
		hong.age = 20;
		hong.name = "홍길동";
		System.out.println(hong.age + hong.name);
		
		hong.먹다();
		hong.웃다();
		
		System.out.println(hong.더한다(10, 20));
		
		
	}

}
