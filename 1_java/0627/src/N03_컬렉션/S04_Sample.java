/*
 * 점수를 보관하는 ArrayList 생성
 * 5개의 점수를 입력받아 저장
 * 점수들의 합계, 평균 출력
 */
package N03_컬렉션;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class S04_Sample {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i=0; i<5; i++) {
			System.out.print("점수 입력 : ");
			al.add((int)(Math.random()*100)+1);// sc.nextInt());
			System.out.print(al.get(i)+"\n");
		}
		int sum = 0;
		for(int i=0; i<al.size(); i++) // ArrayList에 있는 것도 향상된 for문 사용 가능 for(Integer score:al) 도 가능하다는 거
			sum += al.get(i);
		System.out.println("합계 : " + sum + " 평균 : " + (double)sum/al.size());
		
		int sum2 = 0;
		DecimalFormat df = new DecimalFormat("#0.0");
		Collections.sort(al);
		// Collections.max(al); 이런 것도 할 수 있음
		System.out.println("최고점 제외 : " + al.remove(al.size()-1)); // Integer일 경우에는 index랑 value랑 헷갈릴 수 있음, 주의 필요!
		System.out.println("최저점 제외 : " + al.remove(0));
		for(int i=0; i<al.size(); i++)
			sum2 += al.get(i);
		System.out.println(al);
		System.out.println("최고, 최저 제외 평균 : " + df.format((double)sum2/al.size()));
	}

}
