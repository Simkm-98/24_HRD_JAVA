package day05;

abstract class Animal {
	//추상클래스, 적어도 한개 이상의 추상 메소드를 갖는 클래스
	//추상메소드 : { } 바디가 없는 메소드
	
	abstract void sound();
}

class Dog1 extends Animal { // override 안하면 에러뜸
	
	@Override
	public void sound() {
		System.out.println("멍멍");
	}
}

class Cat1 extends Animal {
	
	@Override
	public void sound() {
		System.out.println("야옹");
	}
}

public class AnimalTest {

	public static void main(String[] args) {
		
		// Animal animal = new Animal() -> 추상이기 때문에 불가능
		
		Animal animal =new Dog1();
		animal.sound();
		
		Animal animalCat = new Cat1();
		animalCat.sound();
		
		Dog1 dog1 = new Dog1();
		dog1.sound();
		
		Cat1 cat1 = new Cat1();
		cat1.sound();
		
		animalSound(new Dog1());
		animalSound(new Cat1());
	}
	
	public static void animalSound(Animal animal) {
		animal.sound();
	}

}
