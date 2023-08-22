package N02_쓰레드2;

public interface Msg {
	void attackMsg(int dam);	// 공격 시 출력 메서드
	void userSkillMsg(); 		// 스킬 사용시 출력 메서드
	void hpMsg();				// 체력 출력 메서드
	void endMsg();				// 종료 출력 메서드
	
}
