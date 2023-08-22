package N06_예외처리;

public class S02_Main {

	public static void main(String[] args) {
//		System.out.println(1);
//		try {
//			System.out.println(2);
//			System.out.println(3);
//		} catch(Exception e) {
//			System.out.println(4); // 예외 발생됐을 때만 작동되는 코드이기 때문에 예외발생이 되지 않으면 작동되지 않음
//		}
//		System.out.println(5);
//		
////		System.out.println(1);
////		System.out.println(2);
////		System.out.println(3/0); // 예외발생 시 프로그램 중지
////		System.out.println(4);
////		System.out.println(5);
//		
//		System.out.println(1);
//		try {
//			System.out.println(2);
//			System.out.println(3/0);
//		} catch(Exception e) { // e는 매개변수명이기 때문에 아무렇게나 써도 되지만 보통은 e로 함 // e로 뭐 하는 게 있었던 거 같은데 기억이 ㅡ_ㅡ
//			System.out.println(4); // 예외발생시 catch 실행 후 프로그램 중지가 아니라 코드 다음줄 실행됨
//		}
//		System.out.println(5);
//		
//		
//		System.out.println(1);
//		try {
//			System.out.println(2);
//			System.out.println(3/0);
//		} catch(ArithmeticException e) { // 예외 클래스를 콕찝어서 지정해주는 것이 좋음
//			System.out.println(4);
//		}
//		System.out.println(5);
//		
//		System.out.println(1);
//		try {
//			System.out.println(2);
//			System.out.println(3/0);
//		} catch(ArrayIndexOutOfBoundsException e) { // 상관 없는 예외 클래스를 지정하면 에러 발생됨
//			System.out.println(4);
//		}
//		System.out.println(5);
//		
//		System.out.println(1);
//		try {
//			System.out.println(3/0);
//			System.out.println(2); // 예외가 발생되면 catch로 바로 넘어가기 때문에 실행되지 않음
//		} catch(Exception e) {
//			System.out.println(4);
//		}
//		System.out.println(5);
		
		/*
		 * 예외는 먼저 발생되는 걸로 catch 됨
		 */
		String str = null;
		int[] arr = {1, 2, 3};
		int a = 5;
		try {
			System.out.println(2);
		} catch(ArithmeticException e) { // 예외 클래스를 콕찝어서 지정해주는 것이 좋음
			System.out.println("0으로 나눔");
		} catch(IndexOutOfBoundsException e) { // 상관 없는 예외 클래스를 지정하면 에러 발생됨
			System.out.println("배열범위초과");
		} catch(Exception e) { // 최상위 예외클래스는 제일 나중에 써야 실행됨 아니면 실행 안됨
			System.out.println("걍 예외 발생");
		}
		System.out.println("끝");
	}

}
