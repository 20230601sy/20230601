package N02_다형성;

public class S03_Main {

	public static void main(String[] args) {
		S03_Parent p = new S03_Child();
		p.method1();
		p.method2(); // 자식클래스의 메서드가 실행됨!!!
//		p.method3(); // 이건 안됨, 없는 건 날라감. 정보의 개념으로는 (int), (double)이랑 반대 
		/*
		 * 필드를 어떻게 쓰느냐에 따라서...
		 * 다형성을 활용하는 거임.
		 */
		
		p = new S03_Child2();
		p.method2(); // 같은 참조변수명에 같은 메서드명을 호출했지만 기능은 상황에 따라 달라짐!
	}

}
