package day03;

public class Car {
	
	// 필드 선언
	
	String company;
	String model;
	String color;
	int maxSpeed;
	
	int rpm;
	int speed;
	
	// 인자 생성자 오버로딩
	public Car(String company, String model, String color, int maxSpeed) {
		this.company = company;
		this.model = model;
		this.color = color;
		this.maxSpeed = maxSpeed;
	}
	
	public Car(String company, String model, String color) {
		this(company, model, color, 200); // 위에 생성자 호출
		// 추가 생성문 생성시 위 생성자 호출 후 돌아와서 실행
	}
	
	
	void CarInfo() {
		System.out.println("=======================");
		System.out.println("제조사 : " + company);
		System.out.println("모델 : " + model);
		System.out.println("색상 : " + color);
		System.out.println("최고속력 : " + maxSpeed);
		System.out.println("=======================");
	}
}
