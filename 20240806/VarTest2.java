package day01;

public class VarTest2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int i = 10, j = 20;
		String var1 = "홍길동";
		char var2 = 'a';
		
		System.out.println(i + var2);

		System.out.println(var1);
		
		//강제 형 변환
		
		double k = 3.141592;
		
		j = (int)(j + k);
		System.out.println("j : "+ j + ", k : "+ k);
		
	}

}
