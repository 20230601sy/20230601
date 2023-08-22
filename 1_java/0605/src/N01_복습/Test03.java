// 세 정수를 입력받아 최대값과 최소값을 출력하는 프로그램을 완성하시오
package N01_복습;
import java.util.Scanner;
public class Test03 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("세 정수를 입력하세요 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		int num3 = sc.nextInt();
		int max, min;
		
		max = num1;
		min = num1;
		if (max < num2)
			max = num2;
		if (max < num3)
			max = num3;
		if (min > num2)
			min = num2;
		if (min > num3)
			min = num3;

		System.out.println("최대값 : " + max + " 최소값 : " + min);
	}
}