package N05_내부클래스;

public class S01_Main {
	public static void main(String[] args) {
//		A.B b = new B(); // A객체가 없으면 생성 불가
		S01_A a = new S01_A();
		S01_A.B b = a.new B(); 
		/* 
		 * 이런 거 어디에 쓰나? 우리가 쓸일은 많이 없지만 모바일 쪽에서 쓴다심
		 * 버튼을 눌렀을 때 어떤 행동을 하는지 설정하기 등등..... 
		 */
		
		S01_A.C c = new S01_A.C(); // A 인스턴스 생성 없이 C 인스턴스 생성 가능
		c.method();
		c.method2();
		int cb = S01_A.C.cb; // 이런 거도 가능하다는 거
		S01_A.C.method2();
		
		/*
		 * 지역 클래스(D 클래스)는 Main에서 생성 불가
		 * 메서드에서만 사용하는 클래스이기 때문에 메서드 호출된 생성되나 메서드 내부에서만 접근가능하기 때문에...
		 */
		a.aMethod(); // 할 수 있는 건 이것뿐...
		System.out.println(a.aMethod());
	}

}
