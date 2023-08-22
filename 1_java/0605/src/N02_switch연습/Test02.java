/*
 * 성별을 입력받아 'm', 'M'은 남자, 'f' 'F'는 여자, 나머지는 잘못 입력하셨습니다 출력
 */
package N02_switch연습;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("성별을 입력하세요 : ");
		char gender = sc.next().charAt(0);
		switch(gender) {
			case 'm':
			case 'M':
				System.out.println("남자");
				break;
			case 'f':
			case 'F':
				System.out.println("여자");
				break;
			default:
				System.out.println("잘못 입력하셨습니다");
		}
	}
}