package day05;

public class Person {
		private	String name;
		private int age;
		
		//기본생성자
		public Person() {
		}
		
		//인자생성자
		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}
		
		public void setName(String name) {
			this.name = name;
		}
		
		public String getName() {
			return name;
		}
		
		public void setAge(int age) {
			this.age = age;
		}
		
		public int getAge() {
			return age;
		}
	
		public String personInfo() {
			String info = "이름: " + name + "\n나이: " + age;
			return info;
		}
		
		public void printAll() {
			System.out.println(this.personInfo());
		}

		static void inputPerson() {
			System.out.println("===========");
			System.out.println("이름 입력: ");
			System.out.println("나이 입력: ");
			System.out.println("===========");
		}


}
