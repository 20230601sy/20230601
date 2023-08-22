// 점수 5개를 입력받아 배열에 저장한 후 점수들 중 최대값과 최소값을 출력
package N02_배열;

import java.util.Scanner;

public class Sample06 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] scores = new int[5];
		for(int i=0; i<scores.length; i++) {
			System.out.print((i+1) + "번째 점수 입력 : ");
			scores[i] = sc.nextInt();
		}

		int max = scores[0];
		int min = scores[0];
		for(int score:scores) {
			if(score > max)
				max = score;
			if(score < min)
				min = score;
		}
		System.out.println("최대값 : " + max + " 최소값 : " + min);
	}

}
