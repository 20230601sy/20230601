/*
 *  1부터 100까지 숫자 중 3의 배수이면서 2의 배수가 아닌 수들의 목록, 개수, 합계를 출력하는 프로그램을 완성
 *  <결과 화면>
 *  3 9 15 21 ....
 *  개수 : xx개
 *  합 : yy
 */

package N02_for문;

public class Test05 {

	public static void main(String[] args) {
		int cnt = 0;
		int sum = 0;
		
		for(int i=1; i<=100; i++) {
			if(i%3==0 && i%2!=0) {
				System.out.print(i + " ");
				cnt++;
				sum += i;
			}
		}
		System.out.println("\n개수 : " + cnt);
		System.out.println("합 : " + sum);
	}

}
