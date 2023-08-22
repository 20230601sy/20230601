/* 국어, 영어, 수학 점수를 입력받아
 * 3과목의 평균이 70이상이면 "합격", 아니면 "불합격"으로 출력
 * 단, 평균이 70이상이지만
 * 3과목 중 하나라도 60미만이면 "과락"으로 출력할 것
 */

package N01_복습;

import java.util.Scanner;

public class Test05 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("국어, 영어, 수학 점수를 입력하세요 : ");
		int kor = sc.nextInt();
		int eng = sc.nextInt();
		int math = sc.nextInt();
		
		if ((kor + eng + math)/3.0 >= 70) {
			if (kor < 60 || eng < 60 || math < 60)
				System.out.println("과락");
			else
				System.out.println("합격");
		}
		else
			System.out.println("불합격");
	}

}
