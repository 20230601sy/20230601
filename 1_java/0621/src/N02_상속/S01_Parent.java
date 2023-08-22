package N02_상속;

public class S01_Parent {
	String firstName;
	int money = 100;
	public S01_Parent() {
		System.out.println("부모 생성자 생성");
		firstName = "이";
	}
	public S01_Parent(int money) {
		System.out.println("부모 생성자 생성1");
		firstName = "이";
	}
	public void method() {
		System.out.println("hello" + firstName);
	}
}
