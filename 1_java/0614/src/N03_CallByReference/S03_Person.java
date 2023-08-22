/*
 * 이름, 국어, 영어, 수학, 총점, 평균, 순위
 * 3사람의 이름~수학점수를 입력 받아~~~
 * 총점 계산 메서드
 * 평균 계산 메서드
 * 순위 계산 메서드
 * 과목별 총합계 메서드
 * 성적표 출력
 */
package N03_CallByReference;

public class S03_Person {
	String name;
	int kor, eng, math;
	int sum, rank;
	double avg;
	
	public void setSum() {
		sum = kor + eng + math;
	}
	public void setAvg() {
		setSum();
		avg = sum/3.0;
	}
	public void setRank(S03_Person[] people) {
		rank = 1;
		for(int i=0; i<people.length; i++) {
			if(avg < people[i].avg) {
				rank++;
			}
		}
	}
	public void showInfo() {
		System.out.printf("%s\t%3d %3d %3d %3d %.1f %3d\n", name, kor, eng, math, sum, avg, rank);
	}
}
