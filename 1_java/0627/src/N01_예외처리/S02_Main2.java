package N01_예외처리;

public class S02_Main2 {

	public static void main(String[] args) {
		try {
			try {
				int result = 10/0;
			} catch(ArithmeticException e) {
				throw new S02_CustomException("강제 발생", e);
			}
		} catch(S02_CustomException e) {
			System.out.println("예외 발생 : " + e.getMessage());
			System.out.println("예외 원인 : " + e.getCause().getMessage());
//			e.printStackTrace();
		}
	}

}

/*
 * 예외 발생 : 강제 발생
 * 예외 원인 : / by zero
 * 그냥 StackTrace하면...Stack에 쌓여 있는데 굳이...getCause를...?
 * N01_예외처리.S02_CustomException: 강제 발생
 * 	at N01_예외처리.S02_Main2.main(S02_Main2.java:10)
 * Caused by: java.lang.ArithmeticException: / by zero
 * 	at N01_예외처리.S02_Main2.main(S02_Main2.java:8)
 */