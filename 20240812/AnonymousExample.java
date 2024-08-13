package day05;
interface VehicleEx {
	public void run();
}
class Anonymous {
	VehicleEx field = new VehicleEx() {
		@Override
		public void run() {
			System.out.println("자전거가 달립니다.");		
		}		
	};
	void method1()	{
	VehicleEx localVar = new VehicleEx() {
		@Override
		public void run() {
			System.out.println("승용차가 달립니다.");
			}
		};
		localVar.run();
	}
	void method2(VehicleEx v) {
		v.run();
	}
}
public class AnonymousExample {
	public static void main(String[] args) {
		Anonymous anony = new Anonymous();
		anony.field.run();
		anony.method1();
		anony.method2(new VehicleEx() {
			@Override
			public void run() {
				System.out.println("트럭이 달립니다.");
			}
		});
	}
}
