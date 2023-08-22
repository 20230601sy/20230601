package N03_메서드;

import java.util.Scanner;

public class TheaterMain {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Theater cgv = new Theater();
		
		cgv.init();
		while(true) {
			if(cgv.numTk >= cgv.numSeat) {
				System.out.println("만석입니다. 추가로 예매할 수 없습니다.");
				break;
			}
			System.out.print("[1] 예매하기, [2] 종료하기 : ");
			if(sc.nextInt()==2)
				break;
			cgv.showInfo();
			cgv.ticketing();
		}
		System.out.println("=====영화관 종료=====");
		cgv.showInfo();
		cgv.totalPrice();
	}
}
