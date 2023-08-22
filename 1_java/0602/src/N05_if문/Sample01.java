package N05_if문;

import java.util.Scanner;

public class Sample01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		if(score>=80) {
			System.out.println("합격");
		} else {
			System.out.println("불합격");
		}
	}

}
