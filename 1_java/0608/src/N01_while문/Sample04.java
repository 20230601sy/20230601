// 인원을 먼저 입력 받고, 그다음 각 학생의 성적을 입력 받은 다음, 모든 학생의 합계와 평균을 출력
package N01_while문;

import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수를 입력하시오 : ");
		int nStd = sc.nextInt();	// 학생수
		int sum = 0; 				// 점수 총합
		
		int i=1;
		while(i<=nStd) {
			System.out.print(i + "번째 학생 성적 입력 : ");
			sum += sc.nextInt();
			i++;
		}
		System.out.println(nStd + "명 성적의 총 합계 : " + sum);
		System.out.printf("%d명 성적의 총 평균 : %.2f", nStd, sum/(double)nStd);
	}

}
