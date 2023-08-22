/*
 * 45분 일찍 알람 설정하기
 * 두 H와 M이 주어진다, 0≤H≤23, 0≤M≤59, H시 M분
 * 시간을 나타낼 때, 불필요한 0은 사용하지 않는다
 */
package N01_복습;

import java.util.Scanner;

public class Test07 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("==45분 일찍 알람 설정하기==");
		System.out.print("알람 설정 시간 입력 : ");
		int H = sc.nextInt();
		System.out.print("알람 설정 분 입력 : ");
		int M = sc.nextInt();
		M = M-45;
		if (M<0) {
			M = M+60;
			H = H-1;
			if (H<0)
				H = 23;
		}
		System.out.println("설정된 알람 시간은 " + H + "시 " + M + "분 입니다.");
	}
}
