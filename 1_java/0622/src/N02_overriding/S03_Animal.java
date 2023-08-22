/*
 * Animal 클래스
 * 생성자로 name을 초기화할 수 있도록 구현
 */
package N02_overriding;

public class S03_Animal {
	String name;
	int age;
	
	public S03_Animal(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getAge() {
		return age;
	}
	
}
