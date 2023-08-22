package 게임만들기;

public class Character {
	int hp, mp;
	int attack, defense;
	int x, y;
	int numHP, numMP;
	int weapon;
	int job;
	int[] hpArr = {100, 50, 200};
	int[] mpArr = {50, 100, 25};
	
	public Character(int hp, int mp) {
		this.hp = hp;
		this.mp = mp;
		this.x = 0;
		this.y = 0;
		this.numHP = 5;
		this.numMP = 5;
		this.weapon = 0;
	}
	public Character(int job) {
		this.job = job;
		this.hp = hpArr[job];
		this.mp = mpArr[job];
		this.x = 0;
		this.y = 0;
		this.numHP = 5;
		this.numMP = 5;
		this.weapon = 0;
	}
	public void move(int x, int y) {
		this.x = x;
		this.y = y;
	}
	public void potion(int numHP, int numMP) {
		hp += numHP*100;
		mp += numMP*100;
	}
	public void equipWeapon(int weapon) {
		attack += weapon*100; 
	}
	
}
