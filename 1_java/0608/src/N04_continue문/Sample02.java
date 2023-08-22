/*
 * 숙제! 집에 가서 해오세요~
 * 자판기 [1] 소주, [2] 라면, [3] 커피, [4] 자판기 종료
 * ====자판기 작동중====
 * 어떤 상품을 구매하시겠습니까?
 * ([1] 소주, [2] 라면, [3] 커피, [4] 자판기 종료)
 * 1
 * 소주를 구매하셨습니다.
 * 2
 * 라면을 구매하셨습니다.
 * 9
 * 잘못 입력하셨습니다.
 * 4
 * ====자판기 종료====
 */

package N04_continue문;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("====자판기 작동중====");
		int sel;
		
		while(true) {
			System.out.println("어떤 상품을 구매하시겠습니까?");
			System.out.println("([1] 소주, [2] 라면, [3] 커피, [4] 자판기 종료)");
			sel = sc.nextInt();
			
			if(sel==1)
				System.out.println("소주를 구매하셨습니다.");
			else if(sel==2)
				System.out.println("라면을 구매하셨습니다.");
			else if(sel==3)
				System.out.println("커피를 구매하셨습니다.");
			else if(sel==4) {
				System.out.println("====자판기 종료====");
				break;
			}
			else
				System.out.println("잘못 입력하셨습니다.");
		}
	}
}
