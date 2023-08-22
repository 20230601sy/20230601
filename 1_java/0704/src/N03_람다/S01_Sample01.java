package N03_람다;

public class S01_Sample01 {

	public static void main(String[] args) {
		S01_Calc c = (int a, int b) -> { return a+b; };
		c = (a, b) -> a+b; // 한 줄일 때 중괄호, return 생략 가능(두줄 이상이면 불가능), 자료형은 인터페이스에서 이미 알려줬으니 생략 가능
		// 매개변수가 하나이면 (a) 대신 a 로 괄호 생략 가능
		/*
		 * 람다를 사용할 때 단점은 다른 클래스에서는 새로 생성해야 함(단점이자 장점이라심...)
		 * 람다 용 인터페이스(함수형 인터페이스)에서는 추상메서드가 1개로 고정됨! @FunctionalInterface
		 */
		System.out.println(c.sum(5, 10));
		System.out.println(c.AAA); // 이건 되넹...
		
		// 람다로 쓰레드 생성하는 거 이제 할 수 있음!
		new Thread(()-> {
			for(int i=0; i<10; i++)
				System.out.println("람다로 쓰레드 만들었어요!!!");
		}).start(); // 중괄호 안에 들어간 코드가 결국 run을 구현한 거임
		try { Thread.sleep(500); }catch(Exception e) { }
		System.out.println("메인 종료");
	}
}
