package N04_접근제어자02;

import N03_접근제어자01.Animal;

public class ProtectedTest extends Animal {
	public void test() {
		name = "멍멍이"; // 다른 패키지의 protected 변수도 상속하면 사용 가능  
	}
}
