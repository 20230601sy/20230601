/*
 * Animal 클래스
 * name 멤버변수
 * makeSound() 메서드 - "동물소리 출력" 이라는 출력문이 나오는 메서드
 */

package N01_복습;

public class S01_Animal {
	private String name;
	public S01_Animal(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
//	public void setName(String name) {
//		this.name = name;
//	}
	@Override
	public String toString() {
		return "S01_Animal [name=" + name + "]";
	}
	public void makeSound() {
		System.out.println("동물소리 출력");
	}
}
