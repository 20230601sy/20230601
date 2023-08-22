// 정수 하나를 입력받아 입력받은 정수가 홀수면 "홀수입니다" 짝수면 짝수입니다"라고 출력하는 프로그램을 완성하시오
package N01_복습;
import java.util.Scanner;
public class Test02 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		if (num%2 == 1)
			System.out.print("홀수입니다");
		else
			System.out.print("짝수입니다");
	}
}