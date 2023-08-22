package N02_쓰레드2;

public class PlayUser extends Thread {
	Character user;
	Character com;
	public PlayUser(Character user, Character com) {
		this.user = user;
		this.com = com;
	}
	@Override
	public void run() {
		int damage;
		int coolTime;
		try {
			while(true) {
				coolTime = (int)(Math.random()*3)+1;
				Thread.sleep(coolTime*1000);
				if((int)(Math.random()*10)==5) {
					user.userSkillMsg();
					com.hp -= 30;
				} else {
					damage = (int)(Math.random()*10)+1;
					user.attackMsg(damage);
					com.hp -= damage;
				}
				
				System.out.print("\t");
				com.hpMsg();
				if(com.hp <= 0) {
					user.endMsg();
					System.exit(0);  // break하면 나머지 쓰레드는 종료가 안되니까...break는 여기서 안 됨, 종료 flag 변수 생성 권장하심 귀찮아서 안하셨으면서...헤헷
				}
			}
		} catch(Exception e) {
			
		}
	}
}
