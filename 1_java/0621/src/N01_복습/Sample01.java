/*
 * 변수
 * int a;
 * 정수 1개만 담을 수 있다.
 * 여럭 개의 값을 담도록 한 것이 배열
 * int[] a = new int[6];
 * 배열은 1가지 자료형으로 고정된다.
 * 여러 가지 자료형과 여러 개의 값을 담도록 한 것이 클래스
 * 해당 클래스에 관련된 값만 모아두는 게 관리에 수월함
 */
package N01_복습;

public class Sample01 {
	int a;
	double b;
	boolean c;
	String d;
	int[] arr = new int[5];
//	Student a = new Student(); // Student라는 클래스가 있다고 가정하자
	static int e; // 클래스변수, 모든 객체가 동일한 값을 공유해서 가지면서, 객체 생성 없이도 클래스명으로 호출할 수 있는 변수
	
	public Sample01() {
		/*
		 * 기본생성자, 없어도 자바가 알아서 만들어준다.
		 * 생성자 오버로딩 가능
		 * 생성할 때 한 번만 딱 실행
		 */
	}
	public Sample01(int a) {
		this.a = a;
	}
	public int 메서드이름() {
		return 10;
	}
	public int 메서드이름1() {
		return 메서드이름();
	}
	// 재귀함수
	public int fact(int n) {
		if(n==1)
			return 1;
		return n*fact(n-1);
	}
}
