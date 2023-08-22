package 입력문;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("정수 입력: ");
//		int x = sc.nextInt();
//		System.out.println("입력한 값: " + x);
//		
//		System.out.print("실수 입력: ");
//		double y = sc.nextDouble();
//		System.out.println("입력한 값: " + y);
//		
		System.out.print("문자 입력: ");
		char c = sc.next().charAt(0); // 0 = 문자열의 index
		System.out.println("입력한 값: " + c);

		System.out.print("문자열 입력: ");
		String str = sc.nextLine(); // sc.next() 하면 space 포함하면 첫 공백 앞 단어만, String str = sc.nextLine(); 을 더 많이 씀 
		System.out.print("입력한 값: " + str);

	}

}
