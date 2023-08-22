// 5명의 점수를 입력받아서 순위를 출력
package N02_배열;

import java.util.Scanner;

public class Sample10 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] score = new int[5];
		int[] rank = new int[score.length];
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1) + "번째 학생 점수 입력 : ");
			score[i] = sc.nextInt();
//			rank[i] = i+1;
//			for(int j=0; j<i; j++) {
//				if(score[i] > score[j]) {
//					rank[i]--;
//					rank[j]++;
//				}
//			}
		}
		
		// 강사님이 설명하신 방식 (입력 다 받아야 순위 계산할 수 있음, 같은 점수일 때 처리할 꺼면 이게 유리할 듯)
		for(int i=0; i<score.length; i++) {
			rank[i] = 1; // 배열 초기값이 0이니까 그걸 활용해서 if 조건문에 등호를 포함하면 초기화 할 필요가 없기도 함
			for(int j=0; j<score.length; j++) {
				if(score[i] < score[j]) {
					rank[i]++;
				}
			}
		}
		System.out.println("\n====결과 출력====\n");
		for(int i=0; i<score.length; i++)
			System.out.printf("%d번째 학생 점수 : %3d점, 순위 : %d위\n", i+1, score[i], rank[i]);
	}
}