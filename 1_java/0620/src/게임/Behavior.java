package 게임;

import java.util.Scanner;

public class Behavior {
	Character[] cs;
	int numChar;
	EnemyMap em;
	String[] jobArr = {"전사", "마법사", "도적", "드루이드", "치유사"};
	
	Scanner sc = new Scanner(System.in);
	public Behavior(int maxSize) {
		cs = new Character[maxSize];
		em = new EnemyMap();
	}
	public void mkChar(int job) {
		cs[numChar] = new Character(job);
		numChar = numChar+1;
	}
	public void mkChar(int hp, int mp) {
		cs[numChar] = new Character(hp, mp); 
		numChar = numChar+1;
	}
	
//	public void moveCharater(Character c, int x, int y) {
//		c.move(x, y);
//	}
	public void moveCharater(int index, int x, int y) {
		if(x>=0 && x<=4 && y>=0 && y<=4) {
//			cs[index].x = x;
//			cs[index].y = y;
//			Character c = cs[index];
			cs[index].move(x, y);
		}
		else {
			System.out.println("위치를 잘못 입력하셨습니다.");
		}
	}
	public void CharInfo(int index) {
		System.out.println("=========================");
		System.out.println(jobArr[cs[index].job-1] + "의 HP는 " + cs[index].hp + "이며, MP는 " + cs[index].mp + "입니다.");
		System.out.println(jobArr[cs[index].job-1] + "의 현재 위치는 " + cs[index].x + ", " + cs[index].y + "입니다.");
		System.out.println("=========================");
	}
	public void allCharInfo() {
//		System.out.println("0번 캐릭터 조회" + cs[0].hp);
//		System.out.println("1번 캐릭터 조회" + cs[1].hp);
		System.out.println("=========================");
		for(int i=0; i<numChar; i++) {
//			cs[i].charInfo();
			System.out.println(jobArr[cs[i].job-1]+ "의 HP는 " + cs[i].hp + "이며, MP는 " + cs[i].mp + "입니다.");
			System.out.println(jobArr[cs[i].job-1]+ "의 현재 위치는 " + cs[i].x + ", " + cs[i].y + "입니다.");
			System.out.println("=========================");
			
		}
	}
	public void allJobInfo() {
		System.out.println("=========================");
		for(int i=0; i<numChar; i++) {
			System.out.println(i + ". " + jobArr[cs[i].job-1] + "의 HP는 " + cs[i].hp + "이며, MP는 " + cs[i].mp + "입니다.");
		}
		System.out.println("=========================");
	}
	public int allJobInfo(String str) {
		int index;
		System.out.println("=========================");
		for(int i=0; i<numChar; i++) {
			System.out.println(i + ". " + jobArr[cs[i].job-1] + "의 HP는 " + cs[i].hp + "이며, MP는 " + cs[i].mp + "입니다.");
		}
		System.out.println("=========================");
		System.out.print(str + "캐릭터를 선택해주세요. : ");
		index = sc.nextInt();
		return index;
	}
	public void rmChar(int index) {
		if(index>=0 && index < numChar) {
			for(int i=index; i<numChar-1; i++) {
				cs[i] = cs[i+1];
			}
			numChar--;
			System.out.println("해당 캐릭터가 삭제되었습니다.");
		} else
			System.out.println("캐릭터를 잘못 선택하셨습니다.");
	}
	public void attack(int index) throws Exception{  
		if(em.isEnemy[cs[index].x][cs[index].y]==1) { // 이동했을 때 해당 위치에 적이 있는지 확인 
			System.out.print("적이 있습니다. 공격하시겠습니까? (y/n) : "); // 적이 있으면 우선 공격할 것인지 물어봐서 선택하게 함
			if(sc.next().equals("y")) { // 메서드 체이닝, 메서드가 .으로 연결되어 있을 때는 앞에서부터 시작함. sum(abs()) 이럴 때는 abs가 먼저 호출되고 sum 호출, 괄호 안쪽부터 호출됨
				Character e = em.enemys[cs[index].x][cs[index].y];
				Character c = cs[index]; 
				if(e.hp >= c.hp) { // 해당 캐릭터와 적의 hp를 비교하여 적의 hp가 높으면 캐삭, 패널티 3초 대기
					System.out.println("적이 너무 강해서 캐릭터가 죽고 말았습니다.");
					System.out.println("패널티는 3초 대기입니다.");
					Thread.sleep(3000);
					rmChar(index);
				}
				else { // 해당 캐릭터가 hp가 더 크면 적을 없앰
					System.out.println("약한 적은 제거되었습니다.");
					em.isEnemy[cs[index].x][cs[index].y] = 0;
					em.numEnemy--;
				}
			}
		}
	}
}
