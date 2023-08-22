// 점수를 입력받아 입력한 점수가 80점 이상이면 "상", 60점 이상이면 "중" 나머지는 "하" 출력

package N05_if문;

import java.util.Scanner;

public class Sample02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("점수를 입력해주세요 : ");
		int score = sc.nextInt();
		if(score>=80)
			System.out.println("상");
		else if(score>=60)
			System.out.println("중");
		else
			System.out.println("하");
	}

}
