/*
 * Main
 * 인원수를 입력받은 후
 * 인원수만큼 점수를 입력해서 저장하는 배열 생성
 */
package N03_CallByReference;

import java.util.Scanner;
import java.util.Arrays;

public class S04_CalcMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S04_Calc c = new S04_Calc();
		System.out.print("인원 수 : ");
		int[] score = new int[sc.nextInt()];
		for(int i=0; i<score.length; i++) {
			System.out.print((i+1)+"번째 점수 입력 : ");
			score[i]=sc.nextInt();
		}
		System.out.println("=====결과 출력=====");
		System.out.println("Sum : " + c.calSum(score));
		System.out.printf("Avg : %.1f\n", c.calAvg(score));
		System.out.println("Max : " + c.calMax(score));
		System.out.println("Min : " + c.calMin(score));
		System.out.println("Score : " + Arrays.toString(score));
		System.out.println("SortDec : " + Arrays.toString(c.sortDec(score)));
	}
}
