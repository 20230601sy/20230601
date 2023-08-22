package 평가;

import java.util.Scanner;

public class Mon1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하시오 : ");
		int score = sc.nextInt();
		
		System.out.println();
		System.out.println("[ 연산 결과 ]");
		if(score>=90)
			System.out.println("당신의 점수는 " + score + "점이며, A학점입니다.");
		else if(score>=80)
			System.out.println("당신의 점수는 " + score + "점이며, B학점입니다.");
		else if(score>=70)
			System.out.println("당신의 점수는 " + score + "점이며, C학점입니다.");
		else if(score>=60)
			System.out.println("당신의 점수는 " + score + "점이며, D학점입니다.");
		else
			System.out.println("당신의 점수는 " + score + "점이며, F학점입니다.");
		
	}

}
