package N06_예외처리;

import java.util.Scanner;

public class S01_Sample {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.print("두 수 입력 : ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		System.out.println(a/b); // b=0 입력될 경우 java.lang.ArithmeticException: / by zero
		
		int[] arr = {1, 2, 3};
		System.out.println(arr[4]); // java.lang.ArrayIndexOutOfBoundsException
	}

}
