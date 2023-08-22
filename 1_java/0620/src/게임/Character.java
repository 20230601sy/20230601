package 게임;

public class Character {

	int hp, mp;
	int x, y;
	int job;
//	int attack, defense;
//	String weapon;
//	int numHP, numMP;
	
	public Character() {
		hp = 100;
		mp = 50;
	}
	public Character(int job) {
		this.job = job;
		if(job == 1) {
			hp = 100;
			mp = 20;
		} else if(job == 2) {
			hp = 50;
			mp = 100;
		} else if(job == 3) {
			hp = 80;
			mp = 40;
		} else if(job == 4) {
			hp = 90;
			mp = 40;
		} else if(job == 5) {
			hp = 30;
			mp = 90;
		}
	}
	public Character(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
	}
	public void move(int dx, int dy) {
		x = dx;
		y = dy;
	}
}