package N03_접근제어자01;

public class Animal {
//	private String name;
	protected String name;
//	int age;
	protected int age;
//	Animal(){ // Animal(), public 안 붙이면 default로 설정된 거라 다른 패키지에서 설정이 안됨.
	public Animal() { 
		this.name = "나비";
		this.age = 5;
	}
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
	
}
