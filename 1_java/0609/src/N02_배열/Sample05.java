// 교재 138p 예제: 점수를 보관하는 배열에 100, 88, 100, 100, 90을 저장, 그 점수들의 합계와 평균을 출력
package N02_배열;

public class Sample05 {

	public static void main(String[] args) {
		int[] scores = {100, 88, 100, 100, 90};
		int sum = 0;
		for(int score : scores)
			sum += score;
		System.out.println("합계 : " + sum);
		System.out.println("평균 : " + sum/(double)scores.length);
	}
}
