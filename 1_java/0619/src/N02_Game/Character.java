/*
 * **2조 게임
*Character class
int hp, mp;	 	// 캐릭터 현재 상태
int attack, defense;	 	// 캐릭터 능력치
int x, y; 		 	// 캐릭터 현재 위치
String weapon;	 	// 캐릭터 무기 옵션
int numHP, numMP;	// 포션 소지 수량
void move(dx, dy) method				→ 이준영
void potion(type, num) method			→ 조준용
void attack() method	// 적 공격 후 hp 변경	→ 양선영
void charInfo() method	// 현재 상태 출력		→ 조준용

*State class
Character[] cs;
EnemyMap em;
mkChar() method					→ 조준용
rmChar() method					→ 이준영
void move(char, dx, dy) method			→ 양선영
void portion(type, num) method			→ 조준용
void attack(char) method	// 현재 위치에 적이 있으면 공격, 방어, hp 변경
void charInfo() method	// 현재 상태 출력		→ 양선영

*EnemyMap class (양선영)
Character[] cs;
int[][] map;	 	// 맵 5-by-5
 */
package N02_Game;

public class Character {

}

