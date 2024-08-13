package day06;

public abstract class Product {
	String pname;
	int price;
	
	public void printDetail() {
		System.out.println("상품명: " + pname + " , ");
		System.out.println("가격: " + price + " , ");
		printExtra();
	}
	public abstract void printExtra();
}
