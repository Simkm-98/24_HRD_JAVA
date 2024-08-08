package day03;

public class CalculatorTest {

	public static void main(String[] args) {
		Calculator cal = new Calculator();
		
		cal.x = 150;
		cal.y = 30;
		
		System.out.println(cal.add(100, 40));
		cal.min(100, 40);
		System.out.println(cal.multi());
		cal.div();
		
		double result1 = cal.areaRect(10);
		double result2 = cal.areaRect(10, 20);
		
		System.out.println("정사각형의 넓이 : " + result1);
		System.out.println("직사각형의 넓이 : " + result2);
		
		double result3 = 10 * 10 * Calculator.pi;
		double result4 = 2 * 10 * Calculator.pi;
		
		System.out.println("원의 넓이 : " + result3);
		System.out.println("원의 둘레 : " + result4);
	}

}
