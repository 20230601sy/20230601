/*
 * Student 클래스
 * studentId, name, scores
 * 성적은 사람마다 가지고 있는 개수가 다름
 * → 몇 개의 성적을 입력? // 이거 메인에서 작업
 * 1번 방식 : 생성자는 학번, 이름, 성적 개수를 초기화
 * 2번 방식 : 학생 추가 시도할 경우 학번, 이름, 성적들을 입력받고 생성자에서는 학번, 이름, 성적 초기화 
 *    // 생성자는 학번, 이름, 성적 개수를 초기화
 * 성적들을 입력(추가) 메서드 - addScore (2번 방식이면 꼭 필요한 건 아님)
 * 성적들의 평균을 계산하는 메서드 - avgScore
 */
package N01_성적관리;

import java.util.Arrays;

public class Student {
	String studentId;
	String name;
	int[] scores;
	
//	public Student() {
//		studentId = "";
//		name = "";
//		scores = new int[]{};
//	}
//	public Student(String studentId, String name) {
//		this.studentId = studentId;
//		this.name = name;
//		scores = new int[]{};
//	}
//	public Student(String studentId, String name, int numScores) {
//		this.studentId = studentId;
//		this.name = name;
//		scores = new int[numScores];
//	}
	public Student(String studentId, String name, int[] scores) {
		this.studentId = studentId;
		this.name = name;
		this.scores = scores;
	}
//	public void addScore(int score) {
//		scores = Arrays.copyOf(scores, scores.length+1);
//		scores[scores.length-1] = score;
//	}
	public int sumScore() {
		int sum = 0;
		for(int i=0; i<scores.length; i++) {
			sum += scores[i];
		}
		return sum;
	}
	public double avgScore() {
		return (double)sumScore()/scores.length;
	}
	public void printStudent() {
		System.out.printf("%s %s	%.1f\n", studentId, name, avgScore());
	}
}
