package N01_super;

public class Child extends Parent {
//	int a = 10;
//	
//	public Child() {
//		// super(); 직접 기입하지 않아도, 자동으로 생성
//		System.out.println("Child Cons!");
//	}
//	public void show() {
//		System.out.println("Child class!");
//	}
//	public void show(int a) {
//		System.out.println("parameter a : " + a);
//		System.out.println("child     a : " + this.a);
//		System.out.println("parent    a : " + super.a);
//	}
//	public void re() {
//		System.out.println("===구분선1===");
//		this.show();
//		System.out.println("===구분선2===");
//		super.show();
//		System.out.println("===구분선3===");
//		show(); // 동일 클래스는 this. 생략 가능
//	}
	
	String gender;
	public Child(String name, int age, String gender) {
//		super();
//		this.name = name;
//		this.age = age;
		super(name, age);
		this.gender = gender;
	}
	
}
