/*
 * 후딱 과제요. 주말을 알차게??? ㄷㄷ 
 * 5명의 국어, 영어, 수학점수를 입력받아서 순위를 출력
 * 각 학생의 국영수 합계와 평균 그리고 순위를 출력
 * --------------
 * 1번 학생의 국어점수 입력 : 
 * 1번 학생의 영어점수 입력 :
 * 1번 학생의 수학점수 입력 :
 * ...
 * 5번 학생의 수학점수 입력 :
 * ====성적표====
 * 번호 국어 영어 수학 총점 평균 순위
 */

package N01_숙제;
import java.util.Scanner;
public class Sample01 {
	public static void main(String[] args) {
//		String[] subject = {"국어", "영어", "수학"};
		int cnt = 5;
		String[] name = new String[cnt];
		int[] kor = new int[cnt];
		int[] eng = new int[cnt];
		int[] math = new int[cnt];
		int[] sum = new int[cnt];
		double[] avg = new double[cnt];
		int[] rank = new int[cnt];
		
		Scanner sc = new Scanner(System.in);
		for(int i=0; i<cnt; i++){
			System.out.print((i+1)+"번 학생의 이름 입력 : ");
			name[i] = sc.next();
			System.out.print((i+1)+"번 학생의 국어점수 입력 : ");
			kor[i] = sc.nextInt();
			System.out.print((i+1)+"번 학생의 영어점수 입력 : ");
			eng[i] = sc.nextInt();
			System.out.print((i+1)+"번 학생의 수학점수 입력 : ");
			math[i] = sc.nextInt();
			sum[i] = kor[i] + eng[i] + math[i];
			avg[i] = sum[i]/3.0;
		}
		
		for(int i=0; i<cnt; i++){
			rank[i] = 1;
			for(int j=0; j<cnt; j++) {
				if(avg[i] < avg[j])
					rank[i]++;
			}
		}
			
		System.out.println("====성적표====");
		System.out.println("번호\t국어\t영어\t수학\t총점\t평균\t순위");
		for(int i=0; i<cnt; i++)
			System.out.printf("%d\t%3d\t%3d\t%3d\t%3d\t%.1f\t%d\n", (i+1), kor[i], eng[i], math[i], sum[i], avg[i], rank[i]);
	}
}
// 나중에 클래스 배우면... 배열을 이런 식으로 쓸일은 없을 거라고 하심. 