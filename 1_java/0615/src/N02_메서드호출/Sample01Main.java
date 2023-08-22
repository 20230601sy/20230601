package N02_메서드호출;

public class Sample01Main {

	public static void main(String[] args) {
		Sample01 s = new Sample01();

		s.method1();
		s.method2();
		s.method3();
		
		// 1, 2, 3을 한번에 호출할 일이 반복적으로 생기면 묶어서 하나의 메서드로 생성할 수 있지 않을까 생각하는 거임
		s.allMethod();
		// 지금까지 연습한 메서드들은 여러가지 기능을 한 번에 때려넣은 것들이 많았음
		// 메서드 간 호출이 되면 메서드를 조금 더 세분화(이런 걸 모듈화 시킨다고 표현함)시켜서
		// 메서드 하나에는 하나의 기능만 할 수 있도록 하면
		// 코드를 재사용하기 편해져서 생산성이 올라간다심
	}

}
