package N03_메서드;
public class Cal2 {
	int a, b;
	/*
	 * main에 있는 a, b, 메서드의 매개변수 a, b는 서로 다른 거다
	 * 마찬가지로 main에 있는 a, b와 멤버변수 a, b는 전혀 상관 없는 값
	 * 나중에 메서드에서 a, b를 사용하기 위해 this라는 거를 배운다심
	 */
	public int add(int a, int b) { // 자료형을 설정하면 무조건 return이 있어야 함!
		return a+b; // 리턴이 매서드 종료를 의미함. 그래서 리턴문 아래 작성되는 코드는 절대 실행되지 않음
	}
	public int sub(int a, int b) { 
		return a-b;
	}
	public int abs(int a, int b) { 
		int result;
		if(a>b)
			result = a-b;
		else
			result = b-a;
		return result;
	}
	public int mul(int a, int b) { 
		return a*b;
	}
	public double div(int a, int b) {
		return (double)a/b;
	}
	public void showResult(int result) {
		System.out.println("result : " + result);
	}
	public void showResult(double result) { 
		/* 
		 * 매서드는 클래스나 변수와는 달리 동일한 이름 만들 수 있는데! 대신 매개변수 자료형이나 개수가 다른 걸 생성할 수 있음, 이걸 (메서드) 오버로딩이라고 함. 이거는 꽤나 중요한 용어라고 하심
		 * 메서드 오버로딩 (옛날 단골 면접질문 요즘엔 안 물어볼 걸요? 왜냐면 오버로딩이 있고 오버라이딩이 있고 ... 라심)
		 * 동일한 이름을 가진 메서드를 생성할 수 있다.
		 * 이렇게 되는 이유는 파라미터 자료형에 따라 알아서 찾아가기 때문임
		 */
		System.out.println("result : " + result);
	}
}