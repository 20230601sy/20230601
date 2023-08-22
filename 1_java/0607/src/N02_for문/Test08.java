// 두 정수를 입력받아서 두 수 사이의 소수들의 합계, 개수, 목록을 출력
package N02_for문;

import java.util.Scanner;

public class Test08 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int sum=0, cnt=0;
		if(num1 > num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		
		System.out.println("=== 소수 목록 ===");
		for(; num1<=num2; num1++) {
			int cnt_ = 0;
			for(int j=1; j<=num1; j++) {
				if(num1%j == 0)
					cnt_++;
			}
			if(cnt_ == 2) { // flag && num1>1
				System.out.print(num1 + " ");
				cnt++;
				sum += num1;
			}
		}
		System.out.println();
		
		System.out.println("합계 : " + sum + ", 개수 : " + cnt);
	}
}
