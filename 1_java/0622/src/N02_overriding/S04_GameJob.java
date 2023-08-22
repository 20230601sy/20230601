/*
 * 게임 상 존재하는 여러 직업들(기사, 법사, 힐러)
 * GameJob 클래스
 * int hp; 체력
 * int mp; 마나
 * 체력과 마나를 초기화시켜주는 생성자
 * attack 메서드
 * "기본 공격 시도"라는 문구를 출력
 */
package N02_overriding;

public class S04_GameJob {
	int hp, mp;

	public S04_GameJob(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
	}
	
	public void attack() {
		System.out.println("기본 공격 시도");
	}
	
	public void showInfo() {
		System.out.print("hp : " + hp + " / mp : " + mp);
	}
}
