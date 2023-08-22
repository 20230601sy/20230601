/*
 * 학생 이름과 점수를 입력받음 (종료 : exit)
 * 단, 이름은 중복되지 않는다고 가정
 * 학생 입력 종료 후
 * 전체 학생 수
 * 학생들 중 가장 높은 점수와 이름
 * 학생들의 평균점수을 출력
 */
package N02_컬렉션;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Scanner;

public class S01_Sample01 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		Scanner sc = new Scanner(System.in);
		String studentName;
		int score = 0;
		while(true) {
			System.out.print("학생 이름 입력 (종료:exit)	: ");
			studentName = sc.next();
			if(studentName.equalsIgnoreCase("exit"))
				break;
			if(map.containsKey(studentName)) {
				System.out.println(studentName + " 학생의 점수를 이미 입력하였습니다.");
				continue;
			}
			System.out.print(studentName + " 학생 점수 입력	: ");
			score = sc.nextInt();
			map.put(studentName, score);
		}
		
		System.out.println("==============================");
		if(map.isEmpty()) {
			System.out.println("입력한 학생이 없습니다.");
			return;
		}
		
		System.out.println("전체 학생 수	  	: " + map.size() + "명");
		int scoreSum = 0;
		ArrayList<String> firstList = new ArrayList<>(); // 공동 1등처리
		int maxScore = Collections.max(map.values());
		for(String key : map.keySet()) {
			scoreSum += map.get(key);
			if(map.get(key) == maxScore)
				firstList.add(key);
		}
		DecimalFormat df = new DecimalFormat("#0.0");
		System.out.println("학생 평균		  	: " + df.format((double)scoreSum/map.size()) +"점");
		System.out.println("1등 : " + firstList + " / 점수  : " + maxScore + "점");
	}
}