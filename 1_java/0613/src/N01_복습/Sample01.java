/*
 * Student 클래스를 완성하시오
 * String 이름, int 나이, String 전화번호 멤버변수를 생성
 * main에서 Student 클래스의 인스턴스를 생성하고,
 * 이름, 나이, 전화번호를 저장한 후 출력
 * 정보를 출력하는 메서드를 생성해서 출력할 것
 * 정보출력 메서드 이름 showInfo()
 */
package N01_복습;

public class Sample01 {

	public static void main(String[] args) {
		Student std = new Student();
		std.showInfo();
		std.name = "김이름";
		std.age = 30;
		std.phone = "010-1234-5678";
		std.showInfo();
		
	}
}
