package N01_제네릭;

import java.util.ArrayList;

class Student<T> {
	T score;
	public void method(T score) {
		/*
		 * 매개변수로 받은 값과 score를 더한 결과를 출력해주는 메서드를 구현하고 싶음
		 * 매개변수로 받는 값에 대한 타입은 int? String? double?
		 * this.score + score
		 */
	}
	
//	public void method3(? score) { // 와일드카드 일반 변수는 안 되는가봄 까비. 그렇담 오버로딩 안 했겠지...
//	}
	
	public void method2(ArrayList<?> list) {
		/*
		 * 매개변수로 무조건 ArrayList로 받을 거라고 고정하고,
		 * ArrayList의 제네릭은 고정하고 싶지 않을 때 
		 * ArrayList의 제네릭을 뭐라고 지정하면 좋을까?
		 * T로 하면 될까? 안됨!
		 * T로 하면 Student<String> s = new Student(); 단계에서 자료형이 고정됨!
		 * 이럴 때 나온 게 와일드카드라는 거겠지!
		 */
	}
}

public class S01_Sample01 {

	public static void main(String[] args) {
		Student<String> s = new Student();
		s.score = "100";
		s.method("95");
		ArrayList<String> strList = new ArrayList<>();
		ArrayList<Integer> intList = new ArrayList<>();
		s.method2(strList);
		s.method2(intList);
	}

}
