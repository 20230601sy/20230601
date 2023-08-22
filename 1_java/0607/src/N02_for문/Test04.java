// 두 정수를 입력받아 두 정수 사이의 합계를 구하는 프로그램을 완성하시오

package N02_for문;

import java.util.Scanner;

public class Test04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int sum=0;

//		int min, max;
//		if(num1 >= num2) {
//			max = num1;
//			min = num2;
//		}
//		else {
//			max = num2;
//			min = num1;
//		}
//		for(int i=min; i<=max; i++)
//			sum += i;
//		System.out.println("합계 : " + sum);
		
//		min, max 변수 안 쓰고 이렇게.
//		if(num1 >= num2) {
//			for(int i=num2; i<=num1; i++)
//				sum += i;
//		}
//		else {
//			for(int i=num1; i<=num2; i++)
//				sum += i;
//		}
//		System.out.println("합계 : " + sum);
		
//		for문 한 번에 쓰려면 어떻게 할 수 있을까? swap!
//		if(num1 > num2) {
//			int tmp = num1;
//			num1 = num2;
//			num2 = tmp;
//		}
//		for(int i=num1; i<=num2; i++)
//			sum += i;
//		System.out.println("합계 : " + sum);
		
//		swap & 변수 최소화...굳이 헤헷.
		if(num1 > num2) {
			int tmp = num1;
			num1 = num2;
			num2 = tmp;
		}
		for(; num1<=num2; num1++)
			sum += num1;
		System.out.println("합계 : " + sum);

	}
}


