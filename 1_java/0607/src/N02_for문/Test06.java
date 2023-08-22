/*
 * 소수 - 1과 자기 자신으로만 나눠지는 수
 * 정수를 입력받아 입력한 정수가 소수인지 아닌지를 출력
 */
package N02_for문;
import java.util.Scanner;
public class Test06 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수를 입력하세요 : ");
		int num = sc.nextInt();
		boolean flag = false; // 소수이면 true, 소수가 아니면 false
		for(int i=2; i<num; i++) {
			if(num%i == 0) {
				flag = true;
				System.out.println(i);
				break;
			}
		}
		if(flag)
			System.out.println("소수입니다");
		else
			System.out.println("소수가 아닙니다");
	}
}
