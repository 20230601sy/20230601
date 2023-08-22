/*
 * 싱글톤의 기본 형식
 */
package N02_싱글톤;

public class Singleton {// class 이름은 상관 없음
	
	String name;		// 멤버변수도 이제껏 해온 것처럼 제약 없이 구현하면 됨 
	int no;
	
	private static Singleton singleton = new Singleton(); // 참조변수 선언할 때 여기서 바로 초기화해버림, private static은 꼭 붙어 있어야 함
	
	private Singleton() {
		/* 
		 * 생성자를 private으로 만듦!!! 다른 class에서 객체 절대 생성 불가함
		 * 초기화구현
		 */
		name = "홍길동";
		no = 10;
	}
	
	public static Singleton getInstance() { 
		/*
		 * private static Singleton을 수정은 못하게 하고 사용은 할 수 있도록 하기 위해서 만든 메서드
		 * public static으로 설정
		 * 이름은 상관 없지만 관용적으로 getInstance로 붙이긴 함
		 */
		return singleton;
	}
}
