/*
 * 주사위 눈 3개
 * 같은 눈 3개이면 상금 10,000원 + (같은 눈)x1,000원
 * 같은 눈 2개이면 상금 1,000원 + (같은 눈)x100원
 * 모두 다른 눈이 나오면 가장 (큰 눈)x100원
 */

package N01_복습;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("세 주사위 눈을 입력하세요 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int reward;
		if (num1 == num2 && num1 == num3) 
			reward = 10000 + num1*1000;
		else if ((num1 == num2) || (num1 == num3))
			reward = 1000 + num1*100;
		else if (num2 == num3)
			reward = 1000 + num2*100;
		else {
			if(num1 > num2 && num1 > num3)
				reward = num1*100;
			else if(num2 > num1 && num2 > num3)
				reward = num2*100;
			else
				reward = num3*100;
		}
		System.out.print("상금은 " + reward + "원입니다.");
	}
}