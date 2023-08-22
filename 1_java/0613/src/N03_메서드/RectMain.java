package N03_메서드;

import java.util.Scanner;

public class RectMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Rect r = new Rect();
		System.out.print("가로 입력 : ");
		r.width = sc.nextInt();
		System.out.print("세로 입력 : ");
		r.height = sc.nextInt();		
		r.showInfo();
	}
}