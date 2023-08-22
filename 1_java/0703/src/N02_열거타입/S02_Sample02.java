package N02_열거타입;

import java.util.Arrays;

public class S02_Sample02 {

	public static void main(String[] args) {
		System.out.println("상수 출력		: " + S02_UserRole.ADMIN); // ADMIN 출력됨
		// values() : 열거형의 상수들을 배열로 리턴
		S02_UserRole[] role = S02_UserRole.values(); // 타입은 Enum 명!
		System.out.println("values()	: " + Arrays.toString(S02_UserRole.values()));
		// valueOf(String n) : n과 일치하는 상수를 리턴
		System.out.println("valueOf()	: " + S02_UserRole.valueOf("ADMIN"));
//		String str = S02_UserRole.valueOf("ADMIN"); // 안됨!
		S02_UserRole n = S02_UserRole.valueOf("ADMIN"); // 됨!
		S02_UserRole n1 = S02_UserRole.ADMIN; // 따지고 보면 얘랑 같은데 왜 쓸까? 이렇게는 메인에서 입력 받아서 쓴다하면 못쓰잖아! 이럴 때 valueOf 쓰는 거!
		// name() : 상수를 문자열로 리턴 
		String str = n.name();
		System.out.println("name()		: " + n.name());
		// ordianl() : 상수의 위치를 리턴, 배열처럼 0부터 시작함!
		int i = n.ordinal();
		System.out.println("ordinal()	: " + n.ordinal());
		
		System.out.println("getName()	: " + n.getName()); // getName(): 관리자
	}

}
