// 두 개의 점수를 입력받아 두 점수의 합이 150 이상이고, 평균이 80 이상이면 "합격" 아니면 "불합격"으로 출력하는 프로그램을 완성

package N01_복습;

import java.util.Scanner;

public class Test01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("두 개의 점수를 입력하세요 : ");
		int score1 = sc.nextInt();
		int score2 = sc.nextInt();
		int sum = score1 + score2;
		
		System.out.print("<결과>\n합계 : " + sum + " 평균 : " + sum/2.0);
		
		if (sum >= 160) // sum >= 150 && sum/2 >= 80  
			System.out.println(" 합격");
		else
			System.out.println(" 불합격");
	}

}
