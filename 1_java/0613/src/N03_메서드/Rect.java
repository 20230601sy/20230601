/*
 * 사각형(Rect) 클래스를 완성하시오
 * 사각형 클래스는 가로 width, 세로 height 멤버 변수를 가지고 있음
 * 넓이를 계산하는 calArea() 메서드 구현
 * 둘레를 계산하는 calPeri() 메서드 구현
 * ============================================================
 * 메인에다 하지 말고 사각형 클래스에 하라고 하는 이유
 * 애초에 클래스는 왜 만들까? 유지보수 뭐 이런 거 다 빼고
 * 한 클래스에 연관된 정보들을 묶어서 사용하기 위함
 * 사각형 클래스라면 사각형이 가지고 있는 요소가 뭐가 있을까?
 * 가로, 세로 같은 게 있는 거지
 * 넓이나 둘레는 필수로 가지고 있을 필요는 없지만 가로 세로가 있으면 구할 수 있으니 메소드로 만들라고 한거라고 하심
 */

package N03_메서드;

public class Rect {
	int width;
	int height;
	public int calArea() {
		return width * height;
	}
	public int calPeri() {
		return 2 * (width + height);
	}
	public void showInfo() {
		System.out.println("width : " + width);
		System.out.println("height : " + height);
		System.out.println("Area : " + calArea());
		System.out.println("Peri : " + calPeri());
	}
}
