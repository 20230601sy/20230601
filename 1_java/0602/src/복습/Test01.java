package 복습;

import java.util.Scanner;

/*
 * 0601 복습
 * 대부분의 명령문에는 ; 로 완료, 필요 없는 거는 그때그때 말해주겠음.
 * 출력문: System.out.print("출력할 내용"), println, printf
 * 변수: 값을 저장하는 공간
 * 변수 선언 방법: 데이터타입 변수이름;
 * 데이터타입 종류: 정수 int, short, long / 실수 double, float / 문자 char / 문자열 String (S는 대문자, 정확하게는 데이터타입이 아님) / bool 타입 boolean
 * 변수 이름: 이름만 봐도 대충 뭔지 알 수 있도록 설정 / eg. num1, num2, sum
 * 변수 이름 가이드: 축약 average → avg / 임시 temp, t, tmp / 순서 i, j, k / 특수기호 _ $, 임시저장의 경우 _num1 or num1_ 를 쓰기도 함, $는 거의 안 씀
 * 대입연산자: a=1; 등호 오른쪽에 있는 걸 왼쪽에 넣어라
 * 입력문: import java.util.Scanner; Scanner sc = new Scanner(System.in); int num = sc.nextInt();
 * 데이터타입에 맞게 입력문 명령이 달라짐: nextInt(), nextDouble(), next.charAt(0), nextLine()
 * 자동import 단축키: ctrl + shift + o
 * 자동완성 단축키: ctrl + space
 * 		System.out.print("문자 입력: ");
		char c = sc.next().charAt(0); // 0 = 문자열의 index
		sc.nextLine(); // ← Enter를 한 번 소비시키는 방법도 있음
		System.out.println("입력한 값: " + c);

		System.out.print("문자열 입력: ");
		String str = sc.nextLine(); // sc.next() 하면 space 포함하면 첫 공백 앞 단어만, String str = sc.nextLine(); 을 더 많이 씀 
		System.out.print("입력한 값: " + str);
 */
public class Test01 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("이름을 입력하세요 : ");
		String name = sc.next();
		System.out.print("나이를 입력하세요 : ");
		int age = sc.nextInt();
		System.out.print("성별을 입력하세요 : ");
		char gender = sc.next().charAt(0);
		System.out.print("전화번호를 입력하세요 : ");
		String phone = sc.next();
		System.out.println("====회원정보====");
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("성별 : " + gender);
		System.out.println("전화번호 : " + phone);
		
		
	}

}
