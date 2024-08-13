package day05;

interface Vehicle {
	
	public void run();
}

class Bus implements Vehicle {
	
	@Override
	public void run() {
		System.out.println("버스가 달린다.");
	}
}

class Taxi implements Vehicle {
	
	@Override
	public void run() {
		System.out.println("택시가 달린다.");
	}
}

class Driver {
	
	void drive(Vehicle vehicle) {
		System.out.println("운전자");
		vehicle.run();
	}
	
}
public class DriverTest {

	public static void main(String[] args) {
		// Driver 객체 생성
		Driver driver = new Driver();
		
		//Vehicle 구현 객체 생성
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);
	}

}
