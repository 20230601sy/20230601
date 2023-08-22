/*
 * 정수를 입력받아 입력한 정수가 5의 배수인지 아닌지 출력하는 프로그램을 완성
 */
package N02_switch연습;

import java.util.Scanner;

public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		switch (num%5) {
			case 0:
				System.out.println("5의 배수입니다");
				break;
			default:
				System.out.println("5의 배수가 아닙니다");
		}
	}

}
