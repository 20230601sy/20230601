// 정수를 입력받아 1부터 입력받은 정수까지의 합계를 출력
package N02_for문;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		int sum = 0;
		for(int i=1; i<=num; i++) {
			sum += i;
		}
		System.out.println("합계 : " + sum);		
		
		// 변수 2개로 하면~		
		System.out.print("정수를 입력하세요 : ");
		int t = sc.nextInt();
		sum = 0;
		for(; t>=1; t--) {
			sum += t;
		}
		System.out.println("합계 : " + sum);
		
		// 변수 1개로 하면~
		System.out.print("정수를 입력하세요 : ");
		int tmp = sc.nextInt();
		System.out.println("합계 : " + tmp * (tmp + 1) / 2);
	}
}
