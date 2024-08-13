package day05;

class Car {
	class Tire {}
	static class Engine {}
}

public class CarExample {

	public static void main(String[] args) {
		Car myCar = new Car();
		Car.Tire tire = myCar.new Tire(); //비정적이므로 myCar 인스턴스를 통해 생성
		Car.Engine engine = new Car.Engine(); //정적이므로 인스턴스 없이 생성가능
	}

}
