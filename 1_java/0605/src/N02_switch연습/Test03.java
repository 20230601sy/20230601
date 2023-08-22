/*
 * 두 정수와 연산 기호를 입력받아 결과값을 출력하는 프로그램을 완성
 * 단, 나누기한 결과는 반올림해서(선택사항: Math.round 사용) 소수 둘째자리까지 표시
 * 연산기호는 +, -, *, /, %
 */
package N02_switch연습;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
//		System.out.println("정수 입력 : ");
//		int num1 = sc.nextInt();
//		int num2 = sc.nextInt();
//		System.out.print("연산방법 : ");
//		char op = sc.next().charAt(0);
		System.out.println("===계산식을 입력하세요===");
		int num1 = sc.nextInt();
		char op = sc.next().charAt(0);
		int num2 = sc.nextInt();
//		System.out.print(num1 + " " + op + " " + num2 + " = ");
		switch(op){
			case '+':
				System.out.println(num1+num2);
				break;
			case '-':
				System.out.println(num1-num2);
				break;
			case '*':
				System.out.println(num1*num2);
				break;
			case '/':
//				System.out.printf("%.2f\n",(double)num1/num2);
				System.out.println(Math.round(100*(double)num1/num2)/100.0);
				break;
			case '%':
				System.out.println(num1%num2);
				break;
			default :
				System.out.println("잘못 입력하셨습니다");
		}
	}
}
