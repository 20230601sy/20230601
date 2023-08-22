/*
 * 두 세 자리 수의 곱셈 과정에서 발생되는 값을 구하는 프로그램을 작성하시오. 단, 두 자연수는 세 자리만 입력 받는다.
 */
package 복습;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 자연수를 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.printf("%7d\n   x%d\n───────\n", num1, num2);
		System.out.printf("%7d\n", num1*(num2%10));
		System.out.printf("%6d\n", num1*((num2/10)%10));
		System.out.printf("%5d\n", num1*(num2/100));
		System.out.println("───────");
		System.out.printf("%7d\n", num1*num2);
	}
}
