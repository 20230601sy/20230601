/* 주문수량을 입력받아 주문금액과 배달비를 출력하는 프로그램을 완성
 * - 물건 하나의 가격은 12,000원
 * - 배달비는 주문금액이 15,000원 이하면 3,000원
 *                   30,000원 이하면 1,500원
 *                   나며지는 무료
 */

package N01_복습;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("주문수량을 입력하세요 : ");
		int qty = sc.nextInt();
		final int price = 12000;
		int total = qty * price;
		int delFee;

		if (total < 15000)
			delFee = 3000;
		else if (total < 30000)
			delFee = 1500;
		else
			delFee = 0; 
		
		System.out.print("주문금액 : " + total + " 배달비 : " + delFee);
	}
}
