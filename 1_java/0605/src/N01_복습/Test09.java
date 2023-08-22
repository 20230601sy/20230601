/*
 * 알파벳 한글자를 입력받아 입력한 글자가	소문자면 "소문자를 입력하셨습니다."으로 출력하고,
 * 									대문자면 "대문자를 입력하셨습니다."으로 출력,
 * 									둘다 아닌 경우에는 "알파벳이 아닙니다."라고 출력하시오.
 */
package N01_복습;

import java.util.Scanner;

public class Test09 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("알파벳 한글자를 입력하세요 : ");
		char t = sc.next().charAt(0);
		if (t>='a' && t<='z')
			System.out.print("소문자를 입력하셨습니다.");
		else if (t>='A' && t<='Z')
			System.out.print("대문자를 입력하셨습니다.");
		else
			System.out.print("알파벳이 아닙니다.");
	}

}
