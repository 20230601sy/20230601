/*
 * 영화관
 * 영화 티켓 예매
 * 영화 상영관은 1개! 좌석 10개
 * 영화 가격은 12,000원
 * 예매하면 가격이 나오겠죠
 * 한번에 한 좌석만 예매
 * 예매하기 계속 반복하다 종료하기
 * [1] 예매하기, [2] 종료하기 : 1
 * [ ][ ][ ][ ][ ][ ][ ][ ][ ][ ]
 * 좌석 선택 : 3
 * [1] 예매하기, [2] 종료하기 : 1
 * [ ][ ][V][ ][ ][ ][ ][ ][ ][ ]
 * 좌석 선택 : 3
 * 예매가 불가능한 좌석입니다.
 * [1] 예매하기, [2] 종료하기 : 1
 * [ ][ ][V][ ][ ][ ][ ][ ][ ][ ]
 * 좌석 선택 : 1
 * [1] 예매하기, [2] 종료하기 : 2
 * 총 예매 가격 : 24,000원
 * 그런데 이거 말고도 전매됐을 때! 고려가 필요하지 않을까~~~!!
 */
package N03_메서드;
import java.util.Scanner;
public class Theater {
	final int tkPrice = 12000;
	final int numSeat = 3;
	boolean[] seat = new boolean[numSeat];
	int numTk; // numTk 안쓰고도 가능함~

	Scanner sc = new Scanner(System.in);
	
	public void init() {
		numTk = 0;
		for(int i=0; i<numSeat; i++)
			seat[i] = false;
		System.out.println("=====영화관 예매시스템=====");
	}
	public void ticketing() {
		System.out.print("좌석 선택 : ");
		int selSeat = sc.nextInt();
		if(seat[selSeat-1])
			System.out.println("예매가 불가능한 좌석입니다.");
		else {
			seat[selSeat-1] = true;
			showInfo();
			numTk++;
		}
	}
	public void showInfo() {
		for(int i=0; i<numSeat; i++)
			System.out.print("[" + (seat[i]? "V" : " ") + "] ");
		System.out.println();
	}
	public void totalPrice() {
		System.out.println("총 예매 가격 : " + numTk * tkPrice + "원");
	}
}
