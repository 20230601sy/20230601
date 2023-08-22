package N03_클래스;
public class Animal {
	String name; // 클래스 내에 선언된 변수를 멤버변수라고 함
	int age;
	/*
	 * 클래스에 변수만 설정할 수 있는 게 아니라 메서드, 메소드 (다른 언어에서 함수)도 설정할 수 있음
	 * eg. Math.random(), Math.round() : Math라는 클래스에 있는 random, round 메서드
	 * 메서드 만드는 방법이 다양해서 좀 살펴 보겠음
	 * 형식:
	 * 		접근제한자 리턴타입 메서드이름(매개변수){
	 * 			메서드 기능 구현
	 * 		}
	 * 		접근제한자나 리턴타입 모르니까 지금은
	 * 		public void 메서드이름(){
	 * 			메서드 기능 구현
	 * 		}
	 */
	public void showInfo() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
	}
}
