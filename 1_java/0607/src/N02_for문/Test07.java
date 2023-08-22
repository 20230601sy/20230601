/* 
 * 정수를 입력받아 해당 정수의 팩토리얼을 계산한 결과를 출력
 */
package N02_for문;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int result = 1;
		System.out.print(num + "! = ");
		for(int i=num; i>1; i--) {
			System.out.print(i + " * ");
			result *= i;
		}
		System.out.println("1 = " + result);
	}

}
