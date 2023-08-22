package 게임만들기;

import java.util.Scanner;

public class Behavior {
	Character[] cs;
	int numChar;
	Scanner sc = new Scanner(System.in);
	public Behavior(int maxSize) {
		cs = new Character[maxSize];
		numChar = 0;
	}
	public int inputInt(int min, int max, String str, String strReg) {
		int num;
		while(true) {
			System.out.println("1.전사 2.마법사 3.검사 0.종료");
			System.out.print("직업 입력 : ");
			job = sc.nextInt();
			if(job == 0)
				break;
			if(job == 1 || job == 2 || job ==3) {
				cs[numChar++] = new Character(job);
				break;
			}
		}
	}
	public void mkChar() {
		int job;
		while(true) {
			System.out.println("1.병사 2.마법사 3.검사 0.종료");
			System.out.print("직업 입력 : ");
			job = sc.nextInt();
			if(job == 0)
				break;
			if(job == 1 || job == 2 || job ==3) {
				cs[numChar++] = new Character(job);
				break;
			}
		}
	}
	public boolean mkPossible() {
		return (numChar == cs.length);
	}
	public void rmChar(int num) {
		for(int i = num; i<numChar-1; i++) {
			cs[i] = cs[i+1];
		}
		numChar--;
	}
}
