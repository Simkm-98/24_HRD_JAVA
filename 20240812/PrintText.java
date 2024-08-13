package day05;

public class PrintText implements Printable {

	public static void main(String[] args) {
		
		PrintText pt = new PrintText();
		// Printable pb = new Printable(); -> 불가능
		pt.printMe();
	}

	public void printMe() {
		System.out.println("텍스트파일 출력합니다.");
		
	}

}
