/*
 * Knight 클래스 (GameJob 클래스를 상속받음)
 * int armor (방어력)
 * 방어력까지 초기화 시켜주는 생성자
 * attack 메서드
 * "방패 후리기 공격" 문구 출력
 */
package N02_overriding;

public class S04_Knight extends S04_GameJob {
	int armor;

	public S04_Knight(int hp, int mp, int armor) {
		super(hp, mp);
		this.armor = armor;
	}
	public void attack() {
		System.out.println("방패 후리기 공격");
	}
	public void showInfo() {
		System.out.print("showInfo() : Knight / ");
		super.showInfo();
		System.out.println(" / armor : " + armor);
	}
}
