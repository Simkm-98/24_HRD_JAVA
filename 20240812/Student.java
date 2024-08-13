package day05;

public class Student extends Person{
		
	// ID와 학급변수 cName 추가
	private String id;
	private String cName;

	public Student(String id, String cName, String name, int age) {
		super(name, age);
		this.id = id;
		this.cName = cName;
	}
	
	public void setId(String id	) {
		this.id = id;
	}
	
	public String getId() {
		return id;
	}
	
	public void setcName(String cName) {
		this.cName = cName;
	}
	
	
	public String getcName() {
		return cName;
	}
	
	@Override
	public String personInfo()	{
		
		String info = super.personInfo();
		info += "\n학생ID: " + id + "\n학급이름: " + cName + "\n==============";
		
		return info;
	}
	
}
