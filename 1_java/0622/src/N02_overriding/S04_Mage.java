/*
 * Mage 클래스 (GameJob 클래스를 상속받음)
 * String skill (스킬)
 * 스킬까지 초기화 시켜주는 생성자
 * attack 메서드
 * "xxx 스킬 공격" 문구 출력
 */
package N02_overriding;

public class S04_Mage extends S04_GameJob {
	String skill;
	public S04_Mage(int hp, int mp, String skill) {
		super(hp, mp);
		this.skill = skill;
	}
	public void attack() {
		System.out.println(skill + " 스킬 공격");
	}
	public void showInfo() {
		System.out.print("showInfo() : Mage / ");
		super.showInfo();
		System.out.println(" / skill : " + skill);
	}
}
