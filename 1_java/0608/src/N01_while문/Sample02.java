// 정수 한 개를 입력받아서 입력받은 정수의 해당하는 구구단을 출력
package N01_while문;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		while(true) {
			System.out.print("정수 입력 : ");
			int num = sc.nextInt();
			if(num>9 || num<=1) {
				System.out.println("종료");
				break;
			}
			
			System.out.println("==== " + num + " 단 ====");
			int i = 1;
			while(i <= 9) {
//				System.out.println(num + " * " + i + " = " + num * i);
				System.out.printf("%d * %d = %2d\n", num, i, num*i);
				i++;
			}
		}
	}

}