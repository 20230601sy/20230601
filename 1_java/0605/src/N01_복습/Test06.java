/* 
 * 년도를 입력받아 해당 년도가 윤년인지 아닌지 출력하는 프로그램을 완성하시오
 * 윤년 : 년도가 4의 배수이면서, 100의 배수가 아닌 경우 또는 400의 배수인 경우이다
 */

package N01_복습;

import java.util.Scanner;

public class Test06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("년도를 입력하세요 : ");
		int year = sc.nextInt();
		if ((year%4==0 && year%100!=0) || year%400==0)
			System.out.print("윤년입니다");
		else
			System.out.print("윤년이 아닙니다");
	}
}
