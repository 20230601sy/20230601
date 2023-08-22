/* 
 * 숫자를 입력받아 10~19까지는 F
 * 20~29까지는 D
 * 30~39까지는 C
 * 40~49까지는 B
 * 나머지는 A
 */
package N02_switch연습;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("숫자를 입력하세요 : ");
		int num = sc.nextInt();
		switch(num/10) {
			case 1:
				System.out.println("F");
				break;
			case 2:
				System.out.println("D");
				break;
			case 3:
				System.out.println("C");
				break;
			case 4:
				System.out.println("B");
				break;
			default:
				System.out.println("A");
		}
	}
}
