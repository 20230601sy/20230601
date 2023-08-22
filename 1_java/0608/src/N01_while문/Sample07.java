// 정수를 계속 입력받아 1부터 입력받은 정수까지 3의 배수 개수를 출력 (0을 입력하면 종료)
package N01_while문;

import java.util.Scanner;

public class Sample07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int num;
		while(true) {
			System.out.print("정수 입력(종료 → 0) : ");
			num = sc.nextInt();
			if(num == 0)
				break;
			System.out.println("1부터 " + num + "까지 3의 배수 개수 : " + num/3);
		}
	}
}
