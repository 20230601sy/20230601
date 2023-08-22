/*
 * 쓰레드를 이용해서 User, Com 전투함
 * 기본 데미지 1~10 랜덤
 * 10% 확률로 스킬 사용 (데미지 30)
 * 기본 체력은 둘다 100
 * 공격 속도는 1~3초 랜덤
 */
package N02_쓰레드2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("유저 아이디 입력 : ");
		String id = sc.next();
		Character user = new Character(id, 50);
		Character com = new Character("com", 50);
		PlayUser playUser = new PlayUser(user, com);
		PlayUser playCom = new PlayUser(com, user);
		playUser.start();
		playCom.start();
	}

}
