package N01_복습;
import java.util.Scanner;
public class Sample01 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("====자판기 작동중====");
		int sel;
		Loop:
		while(true) {
			System.out.println("어떤 상품을 구매하시겠습니까?");
			System.out.println("([1] 소주, [2] 라면, [3] 커피, [4] 자판기 종료)");
			sel = sc.nextInt();
			switch(sel) {
				case 1:
					System.out.println("소주를 구매하셨습니다.");
					break;
				case 2:
					System.out.println("라면을 구매하셨습니다.");
					break;
				case 3:
					System.out.println("커피를 구매하셨습니다.");
					break;
				case 4:
					System.out.println("====자판기 종료====");
					break Loop;
				default:
					System.out.println("잘못 입력하셨습니다.");
			}
		}
	}
}