package N01_성적관리;

import java.util.Scanner;

public class SMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("학생 성적 관리 프로그램");
		System.out.print("정원 입력 : ");
//		int maxStudents = sc.nextInt();
		Grade g = new Grade(sc.nextInt());
		String studentId;
		String name;
		int[] scores;
		int choice;
		
		while(true) {
			System.out.print("[1]학생추가 [2]전체조회 [3]학생조회 [4]학생제거 [0]종료 : ");
			choice = sc.nextInt();
			if(choice == 0)
				break;
			switch(choice) {
				case 1:
					if(!g.addPossible()) {
						System.out.println("정원 초과, 현재 학생을 추가 등록할 수 없습니다.");
						break;
					}
					System.out.print("학번 : ");
					studentId = sc.next();
					System.out.print("학생 이름 : ");
					name = sc.next();
					System.out.print("성적수 : ");
					scores = new int[sc.nextInt()];
					for(int i=0; i<scores.length; i++) {
						System.out.print((i+1)+"번째 과목 성적 : ");
						scores[i] = sc.nextInt();
					}
					Student s = new Student(studentId, name, scores);
					g.addStudent(s);
					break;
				case 2:
					g.getAllStudents();
					break;
				case 3:
					System.out.print("조회할 학번 : ");
					g.searchStudent(sc.next());
					break;
				case 4:
					System.out.print("제거할 학번 : ");
					g.removeStudent(sc.next());
					break;
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}
