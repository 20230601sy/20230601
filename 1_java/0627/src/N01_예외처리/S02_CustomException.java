/*
 * 사용자 정의 예외 만들기 307p
 * Exception class를 상속받아서 만듬
 */
package N01_예외처리;

public class S02_CustomException extends Exception {// 기존에 있었던 것을 만들 때 보통 기존 명칭에 custom을 붙임 

	public S02_CustomException(String message) {
		super(message);
	} 
	public S02_CustomException(String message, Throwable cause) {
		super(message, cause);
	}
}
