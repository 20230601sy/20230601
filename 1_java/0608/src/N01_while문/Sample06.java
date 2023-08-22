// 정수를 입력 받아 while문을 사용해서 삼각형 별찍기
package N01_while문;

import java.util.Scanner;

public class Sample06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하시오 : ");
		int num = sc.nextInt();
		
		int i=1;
		while(i<=num) {
			int j=1;
			while(j<=i) {
				System.out.print("*");
				j++;
			}
			System.out.println();
			i++;
		}
	}

}
