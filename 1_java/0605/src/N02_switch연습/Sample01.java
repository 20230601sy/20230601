// 문자를 입력받아 A이면 "최우수", B이면 "우수", C이면 "장려", 나머지는 "잘못 입력하셨습니다." 출력
package N02_switch연습;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("문자를 입력하세요 : ");
		char ch = sc.next().charAt(0);
		switch(ch) {
			case 'A':
				System.out.println("최우수");
				break;
			case 'B':
				System.out.println("우수");
				break;
			case 'C':
				System.out.println("장려");
				break;
			default:
				System.out.println("잘못 입력하셨습니다.");
		}
	}
}
