package N03_CallByReference;

import java.util.Scanner;

public class S03_PersonMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		S03_Person[] people = new S03_Person[3];
		for(int i=0; i<people.length; i++) {
			people[i] = new S03_Person();
			System.out.print((i+1)+"번째 학생 이름 입력 : ");
			people[i].name = sc.next();
			System.out.print((i+1)+"번째 국어 점수 입력 : ");
			people[i].kor = sc.nextInt();
			System.out.print((i+1)+"번째 영어 점수 입력 : ");
			people[i].eng = sc.nextInt();
			System.out.print((i+1)+"번째 수학 점수 입력 : ");
			people[i].math = sc.nextInt();
			people[i].setSum();
			people[i].setAvg();
		}
		System.out.println("===============성적표===============");
		int korSum = 0, engSum = 0, mathSum = 0;
		for(int i=0; i<people.length; i++) {
			people[i].setRank(people);
			people[i].showInfo();
			korSum += people[i].kor;
			engSum += people[i].eng;
			mathSum += people[i].math;
		}
		System.out.println("===============과목합===============");
		System.out.printf("\t%3d %3d %3d", korSum, engSum, mathSum);
	}
}
