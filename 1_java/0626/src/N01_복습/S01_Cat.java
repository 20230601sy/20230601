/*
 * Cat 클래스 Animal 클래스 상속
 * color 멤버변수
 * 생성자를 통해 이름과 색상을 초기화
 * makeSound() 메서드를 오버라이딩해 "냐옹"이라는 출력문이 나오는 메서드
 */
package N01_복습;

public class S01_Cat extends S01_Animal {
	private String color;
	public S01_Cat(String name, String color) {
		super(name);
		this.color = color;
	}
	
	@Override
	public String toString() {
		return "S01_Cat [toString()=" + super.toString() + ", color=" + color + "]";
	}

	@Override
	public void makeSound() {
		System.out.println("냐옹");
	}
}