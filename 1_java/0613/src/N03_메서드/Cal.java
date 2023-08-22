package N03_메서드;

public class Cal {
	public void hello() {
		System.out.println("계산기 프로그램입니다");
	}
	public void add(int a, int b) { 
		// 매개변수(parameter) 이름을 Main과 같이 할 필요는 없지만, 보통은 맞춰서 쓰는 편이긴 하다심
		// int a, b로 int를 생략할 수 없음!!!
		System.out.println(a+b);
	}
	public int add1(int a, int b) {
		return a+b;
	}
	public void sub(int a, int b) { 
		System.out.println(a-b);
	}
	public void mul(int a, int b) { 
		System.out.println(a*b);
	}
	public void div(int a, int b) { // double a, int b 로 하고 a/b 해도 되는 듯!
//		if(b==0)
//			System.out.println((double)a/b + " : 0으로 나눌 수 없어요");
//		else
			System.out.println((double)a/b);
	}
	public void abs(int a, int b) {
		System.out.println((a>=b)? a-b : b-a);
	}
}
