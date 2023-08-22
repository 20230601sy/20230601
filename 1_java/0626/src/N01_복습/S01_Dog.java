/*
 * Dog 클래스 Animal 클래스 상속
 * breed 멤버변수
 * 생성자를 통해 이름과 견종을 초기화
 * makeSound() 메서드를 오버라이딩해 "멍멍"이라는 출력문이 나오는 메서드
 */
package N01_복습;

public class S01_Dog extends S01_Animal {
	private String breed;
	public S01_Dog(String name, String breed) {
		super(name);
		this.breed = breed;
	}
	
	@Override
	public String toString() {
		return "S01_Dog [toString()=" + super.toString() + ", breed=" + breed + "]";
	}

	@Override
	public void makeSound() {
		System.out.println("멍멍");
	}
}