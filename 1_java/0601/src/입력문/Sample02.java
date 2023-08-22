package 입력문;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

//		System.out.print("첫번째 정수 입력: ");
//		int a = sc.nextInt();
//		System.out.println("입력한 값: " + a);
//		
//		System.out.print("두번째 정수 입력: ");
//		int b = sc.nextInt();
//		System.out.println("입력한 값: " + b);

		System.out.print("두 정수 입력: ");

		int a = sc.nextInt();
		int b = sc.nextInt();

		System.out.println("첫번째 입력한 값: " + a + ", 두번째 입력한 값: " + b);
		
		System.out.println("a+b: " + (a+b));
		System.out.println("a-b: " + (a-b));
		System.out.println("a*b: " + (a*b));
		System.out.println("a/b: " + (a/(double)b));
		System.out.println("a%b: " + (a%b));
		
	}

}
