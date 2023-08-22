package N02_메서드호출;

public class Sample01 {
	public void method1() {
		System.out.println("메서드1 호출");
	}
	public void method2() {
		System.out.println("메서드2 호출");
	}
	public void method3() {
		System.out.println("메서드3 호출");
	}
	public void allMethod() {
		method1();
		method2();
		method3();
	}
	// 클래스에서 객체를 생성해서 사용할 수 있을까? 당연 가능, 메인에서 사용하는 거랑 별반 다르지 않음
	
}
