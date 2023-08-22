package 복습;

import java.util.Scanner;

public class Test02 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
//		System.out.print("국어 점수를 입력 : ");
//		int kor = sc.nextInt(); 
//		System.out.print("영어 점수를 입력 : ");
//		int eng = sc.nextInt();
//		System.out.print("수학 점수를 입력 : ");
//		int math = sc.nextInt();
//		int sum = kor + eng + math;
//		System.out.println("점수 총합 : " + sum);
//		int nSubject = 3;
//		double avg = sum/(double) nSubject;
//		System.out.printf("점수 평균 : %.1f\n", avg);

		System.out.print("국어 점수를 입력 : ");
		int sum = sc.nextInt(); 
		System.out.print("영어 점수를 입력 : ");
		sum += sc.nextInt();
		System.out.print("수학 점수를 입력 : ");
		sum += sc.nextInt();
		System.out.println("점수 총합 : " + sum);
		System.out.printf("점수 평균 : %.1f\n", sum/3.0);
		
		
	}

}
