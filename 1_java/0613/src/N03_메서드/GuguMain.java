/*
 * 구구단을 출력해주는 메서드를 생성
 * 클래스 이름 : Gugu
 * 메서드 이름 : showGugu
 * 메인 클래스 이름 : GuguMain
 * 메인에서 정수를 입력받으면
 * 입력받은 정수에 대한 구구단이 출력되도록 구현
 */
package N03_메서드;

import java.util.Scanner;

public class GuguMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("정수 입력 : ");
		int num = sc.nextInt();
		
		Gugu g = new Gugu();
		g.showGugu(num);

	}

}
