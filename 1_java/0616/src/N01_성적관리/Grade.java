/*
 * Grade 클래스, 학생들을 관리하는 클래스
 * 학생들을 저장하는 배열 - students
 * 학생 수도 정해져있지 않음 - 생성자로 초기화
 * 학생을 추가하는 메서드 - addStudent
 * 학생 전체 목록(학번, 이름, 평균점수) 조회하는 메서드 - getAllStudents
 * 학번을 기준으로 검색이 되어 특정 학생을 조회 후 학번, 이름, 평균점수 출력하는 메서드 - searchStudent
 * 학번을 입력받아 해당 학생을 삭제하는 메서드 - removeStudent
 */
package N01_성적관리;

public class Grade {
	int numStudents;
	Student[] students;
	public Grade() {
		int maxStudents = 30;
		numStudents = 0;
		students = new Student[maxStudents];
	}
	public Grade(int maxStudents) {
		numStudents = 0;
		students = new Student[maxStudents];
	}
	public boolean addPossible() {
		if(students.length <= numStudents)
			return false;
		return true;
	}
	public void addStudent(Student s) {
		if(!addPossible()) {
			System.out.println("정원 초과, 현재 학생을 추가 등록할 수 없습니다.");
			return;
		}
		students[numStudents] = s;
		numStudents++;
	}
	public void getAllStudents() {
		if(numStudents==0) {
			System.out.println("현재 등록된 학생이 없습니다.");
			return;
		}
		System.out.println("학번	 이름	평점");
		for(int i=0; i<numStudents; i++) {
			students[i].printStudent();
		}
	}
	public int searchStudentIndex(String studentId) {
		for(int i=0; i<numStudents; i++) {
			if(studentId.equalsIgnoreCase(students[i].studentId)) {
				return i;
			}
		}
		System.out.println("해당 학생이 존재하지 않습니다.");
		return -1;
	}
	public void searchStudent(String studentId) {
		int index = searchStudentIndex(studentId);
		if(index == -1)
			return;
		System.out.println("학번	 이름	평점");
		students[index].printStudent();
	}
	public void removeStudent(String studentId) {
		int index = searchStudentIndex(studentId);
		if(index == -1)
			return;
		for(int i=index; i<numStudents-1; i++)
			students[i] = students[i+1]; 
		numStudents--;
	}
}
