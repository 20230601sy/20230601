package N05_내부클래스;

public class S01_A {
	class B {
		int ba;
//		static int bb; // 인스턴스 클래스에서는 static 변수나 메서드 안됨!, A객체가 없으면 B.b를 호출할 수 없음. 그러니까 안되는 이유는 간단한 거지. 
		B(){
			// 생성자 가능
			System.out.println("B 클래스 생성자");
		}
		void method() {
			System.out.println("B 클래스 메서드");
		}
//		static void method2() {} // 안됨!
	}
	
	static class C{
		int ca;
		static int cb; // 인스턴스 클래스와 달리 static 변수, 메서드 가능!
		C(){
			// 생성자 가능
			System.out.println("C 클래스 생성자");
		}
		void method() {
			System.out.println("C 클래스 메서드");
		}
		static void method2() {
			System.out.println("C 클래스 static 메서드");
		}
	}
	
	public int aMethod() {//void aMethod() {
		System.out.println("A 클래스 메서드");
		class D{ // aMethod()가 작동되어야 D class가 생성되는 것이기 때문에, class 앞에 접근제한자라든지 static도 못 붙임
			int da;
//			static int db; // 안됨
			D(){
				System.out.println("D 클래스 생성자");
			}
			void method() {
				System.out.println("D 클래스 메서드");
			}
//			static void method2() {} // 안됨!
		}
		D d = new D(); // 지역클래스는 메서드 내부에서 인스턴스 생성해서 사용하기 위함
		d.method();
		d.da = 10;
		return d.da;
	}
}
