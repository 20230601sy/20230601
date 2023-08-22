package N03_메서드;

import java.util.Scanner;

public class Cal3Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num1 = sc.nextInt();
		int num2 = sc.nextInt();
		System.out.print("연산기호 입력 : ");
		char op = sc.next().charAt(0);
		
		Cal3 c = new Cal3();
		c.showResult(num1, num2, op);
	}
}
