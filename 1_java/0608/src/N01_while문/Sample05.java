// 정수를 입력받아서 입력받은 정수의 각 자리수 합계를 출력, 교재 117p 예제
package N01_while문;

import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		int sum = 0;
		String str = "";
		
		while(num>=1) {
			sum += num%10;
			str = ((num/10>=1) ? " + " : "자리수 합 : ") + num%10 + str;
			num /= 10;
		}
		System.out.println(str + " = " + sum);

	}

}
