package model.domain;

public class Student {
	private String name;
	private int age;
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Student(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}
	
	@Override
	public String toString() {
//		StringBuilder builder = new StringBuilder();
//		builder.append("Student [name=");
//		builder.append(name);
//		builder.append( ", age=");
//		builder.append(age);
//		builder.append("]");
//		return builder;	
		
		return "Student [name=" + name + ", age=" + age + "]";
	}
}
