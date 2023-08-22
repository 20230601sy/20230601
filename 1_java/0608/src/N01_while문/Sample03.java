// 하나의 정수를 입력받아 1부터 해당 정수까지의 홀수의 합과 개수를 출력
package N01_while문;

import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int sum=0, cnt=0;
		
		int i = 1;
		while(i<=num) {
			if(i%2 == 1) {
				sum += i;
				cnt++;
			}
			i++;
		}
		
//		while(num>=1) {
//			if(num%2 == 1) {
//				sum += num;
//				cnt++;
//			}
//			num--;
//		}

		System.out.println("홀수 합 : " + sum + " 개수 : " + cnt);
	}
}
