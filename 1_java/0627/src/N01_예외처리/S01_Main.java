package N01_예외처리;

public class S01_Main {

	public static void main(String[] args) {
		
		System.out.println(1);
		try {
			System.out.println(2);
//			System.out.println(3/0);
			throw new Exception("예외 강제 발생"); // 301p 강제로 발생시키는 거, 사용 목적: 테스트할 때 확인용으로 사용
//			System.out.println("bbbbb"); // 예외 강제 발생 이후 코드는 실행이 되지 않기 때문에 이클립스 자동 에러로 실행 안됨 
		} catch(ArithmeticException | IndexOutOfBoundsException  e) { // bit "|" OR연산
		}
		catch(Exception e) {
			System.out.println("걍 예외 발생");
			/*
			 * 299p
			 * 예외처리가 발생되었을 때 메세지 출력해주는 메서드
			 */
			System.out.println("0 ====================");
			e.printStackTrace(); // 얘가 제일 길게 나오네. 예외처리 안하면 출력하고 종료되는 문구 그대로 출력되는 듯.
			/*
			 * Console eg.
			 * java.lang.Exception: 예외 강제 발생
			 * at N01_예외처리.S01_Main.main(S01_Main.java:11)
			 */
			System.out.println("1 ====================");
			System.out.println(e.getMessage()); // 이건 toString처럼 조금 간단하게 나옴
			// Console eg. : 예외 강제 발생
			System.out.println("2 ====================");
			System.out.println(e.toString()); // 언제 예외가 발생했는지 모를 경우 try catch로 해둔다음 로그 찍는 거...
			// Console eg. : java.lang.Exception: 예외 강제 발생
			System.out.println("3 ====================");
			/*
			 * catch에 꼭 뭐를 넣어야 할 필요가 없고 테스트할 때는 
			 * 일반 유저들한테 이런 걸 보여줄 필요는 없고 안내 문구 같은 거 쓰는 거니까... 
			 */
		}
		System.out.println("끝");
		/*
		 * 예외 떠넘기기
		 * 이런 거 어디다 쓰냐?
		 * 나중에 데이터베이스랑 연관이 있긴 함 
		 * 트랜잭션 (하나의 작업단위)
		 * 예를 들어 쇼핑몰에서 1. 주문 → 2. 입금 → 3. 택배 발송 3단계로 작업을 나눴다고 생각해보면,
		 * 상품 발송(){
		 * 	주문();
		 *  입금();
		 *  택배 발송():
		 * }
		 * 주문, 입금, 택배 발송 예외가 발생했다고 할 때, 주문 취소를 위해서 try~catch로 묶어줘야 할 것임.
		 * 상품 발송(){
		 * 	try{
		 *   주문();
		 *   입금();
		 *   택배 발송():
		 *  } catch() {
		 *   어디서 예외가 발생하든 전부 취소();
		 *  }
		 * }
		 * 주문, 입금, 택배 발송(){
		 *  try{
		 *   기능 구현
		 *  } catch() {
		 *   예외처리
		 *  }
		 * }
		 * 주문, 입금, 택배 발송 예외처리에서만 예외가 처리되고 나머지 트랜잭션은 실행이 되기 때문에
		 * 예외 떠넘기를 사용하여 나머지 트랜잭션이 실행되지 않도록 한 거임
		 * 사실상 여러 작업한 거를 하나로 묶은 거임. 
		 * 데이터베이스할 때 예외 발생 시 롤백되어야 하기 때문에 중요한 개념이라 다시 얘기하신다심 
		 */
		try {
			div(5,0); // 메서드 호출에는 문제가 없고 메서드 내부에서만 예외가 발생해서 메서드 catch만 작동하는데, 이거를 호출한 위치에서도 예외를 발생하게 하도록
		} catch (Exception e) {
			System.out.println("메서드 에러 : " + e.getMessage());
		}
	}
	
	public static void div(int a, int b) throws Exception { // main 바깥에 메서드, static 붙여야 함
		try {
			System.out.println(a/b);
		} catch (Exception e) {
			System.out.println("div메서드 예외 발생");
			throw new Exception("0으로 못 나눔"); // 예외발생을 강제로 시켰다는 의미는...원래는 try문 안에 있어야 하는 거 넘길 곳을 메서드 명에 "throws 예외클래스명"(throw 아님 s 붙어야 함, 생성한 예외와 동일클래스)
		} finally {
			/*
			 * 원래 try-catch finally가 한 세트인데 뭐 사실 별로 쓸일은 없을 듯
			 * 그냥 예외가 발생하든 발생하지 않든 언제든 실행되는 코드를 작성하는 곳
			 * if-else 여서 else??? 같은 느낌이라시는데 그건 좀 이상한 비유...그그 필요 없으면 안 써도 된다는 의미에서 사용하신 듯.
			 */
			System.out.println("마지막에 실행~");
		}
		// 예외처리 클래서 상속받아서 직접 만들어서 쓸 수 있음
	}
}
