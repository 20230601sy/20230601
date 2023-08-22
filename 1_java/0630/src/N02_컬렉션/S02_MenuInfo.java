/*
 * 카페 메뉴 관리 프로그램
 * MenuInfo 클래스
 * name ex) 아메리카노
 * price ex) 2000
 * group ex) 커피
 * type ex) 진한 커피
 * 멤버 변수들을 초기화해주는 생성자 구현
 */
package N02_컬렉션;

public class S02_MenuInfo {
	String name;
	int price;
	String group;
	String type;
	public S02_MenuInfo(String name, int price, String group, String type) {
		this.name = name;
		this.price = price;
		this.group = group;
		this.type = type;
	}
	@Override
	public String toString() {
		return name + "	: " + price + "원, " + group + "	/ " + type;
	}
	
	public String showInfo2() {
		return "[1] " + name + " [2] " + price + "원 [3] " + group + " [4] " + type;
	}
	
}
