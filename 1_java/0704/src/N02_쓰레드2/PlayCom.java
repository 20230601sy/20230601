package N02_쓰레드2;

public class PlayCom extends Thread {
	Character user;
	Character com;
	public PlayCom(Character user, Character com) {
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
					com.userSkillMsg();
					user.hp -= 30;
				} else {
					damage = (int)(Math.random()*10)+1;
					com.attackMsg(damage);
					user.hp -= damage;
				}
				System.out.println(user.userId + " 의 남은 체력 : " + user.hp);
				if(user.hp <= 0) {
					com.endMsg();
					System.exit(0);
				}
			}
		} catch(Exception e) {
			
		}
	}
}
