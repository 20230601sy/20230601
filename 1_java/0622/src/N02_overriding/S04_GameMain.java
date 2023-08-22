/*
 * Main 클래스
 * Knight 객체, Mage 객체 생성
 * 각각 정보 출력, attack 호출
 */
package N02_overriding;

public class S04_GameMain {

	public static void main(String[] args) {
		S04_Knight k = new S04_Knight(100, 50, 200);
		S04_Mage m = new S04_Mage(50, 100, "스톤");
		System.out.println("Knight hp/mp/armor : " + k.hp + "/" + k.mp + "/" + k.armor);
		k.showInfo();
		k.attack();
		System.out.println("Mage   hp/mp/skill : " + m.hp + "/" + m.mp + "/" + m.skill);
		m.showInfo();
		m.attack();
	}

}
