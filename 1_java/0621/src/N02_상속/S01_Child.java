package N02_상속;

public class S01_Child extends S01_Parent{ // 자식클래스 이름 뒤에 extends 부모클래스이름 자식 클래스가 부모 클래스에 있는 것을 상속받을 거다라고 알려줌!
//	String firstName;
//	int money;
	int age; // 상속 받은 거 외에 추가로 구현할 수 있다. 당연히
	public S01_Child() {
//		S01_Parent(100);
		super(100);
		System.out.println("자식 생성자 생성");
		firstName = "김";
	}
	public void method2() {
		method();
	}
}
