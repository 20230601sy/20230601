package 논리연산;

public class Sample01 {

	public static void main(String[] args) {
		int a=8, b=20;
		// 조건식을 한 번에 묶거나 부등식을 한 번에 쓸 수 없으니 모두 따로 따로 표기해야 함
		// 각각의 조건식을 먼저 계산함 → 괄호 필요 없음
		System.out.println( a>=5 && b>=15 );
		System.out.println( a>=5 && b<=15 );
		System.out.println( a>=5 || b<=15 );
	}

}
