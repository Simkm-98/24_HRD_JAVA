package day02;

public class RefType {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		RefType ref = new RefType();
		// ref 스택(stack)영역 (100번지를 참조)
		// new -> heap 에 RefType 새로운 주소 할당 ex) 100번지
		RefType ref2 = new RefType(); // heap 101번지 할당
		//지역변수(stack) ref, ref2 쌓임
		// ref2 101번지 참조
		// ref, ref2 오브젝트라고 부름.
		
		if (ref == ref2) {
			System.out.println("주소가 같다");
		}else {
			System.out.println("다른 주소를 갖는다" + ref + " || " + ref2);
		}
		// 참조 변수처럼 사용하기
		String name = new String("심경민");
		System.out.println(name.length());
		// 기본형처럼 사용
		String name2 = "심경민2";
		System.out.println(name2.charAt(1));
		
		int[] score = new int[5];
		score[0] =10;
		score[1] =20;
		score[2] =30;
		score[3] =40;
		score[4] =50;
		
		int sum = 0;
		for (int i =0; i < score.length; i++) {
			sum= sum + score[i];
		}
		System.out.println("총합 : " + sum);
	}

}
