package N02_상속;

public class S01_Main {
	public static void main(String[] args) {
		S01_Parent p = new S01_Parent();
		System.out.println("1");
		S01_Child c = new S01_Child();
		System.out.println("2");
//		p.firstName = "김";
//		System.out.println(p.firstName);
//		c.firstName = "박";
//		System.out.println(c.firstName);
//		c.age = 10; // p.age는 사용 불가, 물려받는 것은 일방적인 것임!
//		p.method();
//		c.method();
//		c.method2();
		// 결론적으로 부모클래스보다 자식클래스의 기능이 무조건 같거나 많다!
		System.out.println(c.firstName); // 생성자도 상속이 되기 때문에 부모에서 값을 지정해줬으면 자식에서도 동일한 값으로 지정됨
		// 생성자도 물려준다!
		// 부모생성자를 먼저 실행시킨 다음 자식생성자를 실행시킴(눈에 안 보이지만 내부적으로는 부모클래스의 기본생성자로 부모 인스턴스가 만들어진 것임)
		// 부모클래스의 생성자는 상속되지 않음. 나중에는 따로 호출하는 방법을 쓸 거라고 하심??? super 봤던 거 같기도 하다 ㅡㅡ
		// 부모클래스에 생성자를 추가 했을 때 기본생성자가 없으면?? 에러 나온다. 추가된 부모클래스의 생성자를 호출하려면 super(parameter);
		System.out.println(c.money);
	}
}
