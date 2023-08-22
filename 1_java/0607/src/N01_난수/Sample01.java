/*
 * 교재 109p
 * Math.random() → 랜덤
 * 0~0.999999999999 (1전까지)
 * 따지자면, Math는 class, random()은 method, M이 대문자
 * 할 때마다 다른 값을 가짐, 모두 다른 값 출력
 * round와 동일하게 추가 해야 할 것이 있음 ∵ 보통은 1~10 중에서 정수 하나를 고르라는 식이므로...
 * 로또 번호 생성기 같은 거 할 때 쓸 거임???
 * eg. 1~X → 1+X*Math, 0~Y → Y*Math...???
 */
package N01_난수;

public class Sample01 {

	public static void main(String[] args) {
		System.out.println(((int)(Math.random()*10)+1));
	}

}
