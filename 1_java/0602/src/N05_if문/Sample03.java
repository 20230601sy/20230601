// 교재 105p 예제
package N05_if문;

import java.util.Scanner;

public class Sample03 {

	public static void main(String[] args) {
		
		char grade = ' ';
		char opt = '0';
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력하세요 : ");
		int score = sc.nextInt();
		System.out.println("당신의 점수는 " + score + "점 입니다.");
		if(score>=90) {
			grade = 'A';
			if (score>=98)
				opt = '+';
			else if (score<94)
				opt = '-';
		} else if(score>=80) {
			grade = 'B';
			if (score>=88)
				opt = '+';
			else if (score<84)
				opt = '-';
		} else {
			grade = 'C';
		}
		System.out.println("당신의 학점은 " + grade + opt + "입니다.");
	}

}
