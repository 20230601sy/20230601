// 정수를 입력받아 1부터 해당 값까지 합계를 구하는 프로그램을 do-while을 사용하여 완성
package N02_do_while문;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int sum = 0;
		
		do {
			sum += num;
			num--;
		} while(num>=1);
		System.out.println("합계 : " + sum);
	}

}
