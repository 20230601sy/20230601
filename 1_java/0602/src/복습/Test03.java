package 복습;

import java.util.Scanner;

public class Test03 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("금액 : ");
		int money = sc.nextInt();
		System.out.println("<결과>");
//		System.out.println("5만원권 : " + money/50000 + "장");
//		money %= 50000;
//		System.out.println("만원권 : " + money/10000 + "장");
//		money %= 10000;
//		System.out.println("오천원권 : " + money/5000 + "장");
//		money %= 5000;
//		System.out.println("천원권 : " + money/1000 + "장");
//		System.out.println("잔돈 : " + money%1000 + "장");
		
		System.out.println("5만원권 : "	+ money/50000 + "장");
		System.out.println("만원권 : "	+ (money%50000)/10000 + "장");
		System.out.println("오천원권 : "	+ (money%10000)/5000 + "장");
		System.out.println("천원권 : "	+ (money%5000)/1000 + "장");

	}

}
