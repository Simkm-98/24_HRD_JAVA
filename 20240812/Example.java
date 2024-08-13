package day05;
interface A {
	public void method1();
}

class B implements A {

	@Override
	public void method1() {
		System.out.println(" B - method1()");
	}
}

class C implements A {
	@Override
	public void method1() {
		System.out.println(" C - method1()");
	}
	
	public void method2() {
		System.out.println(" C - method2()");
	}
}
public class Example {
	
	public static void action(A a) {
		a.method1();
		C c = null;
		if (a instanceof C) {
			c = (C) a; //형변환 다운 캐스팅
			c.method2();
		}
	}
	public static void main(String[] args) {
		action(new B());
		action(new C());

	}

}
