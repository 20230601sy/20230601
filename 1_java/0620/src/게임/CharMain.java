package 게임;

import java.util.Scanner;

public class CharMain {

	public static void main(String[] args) throws Exception {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("소환사의 협곡에 오신 여러분을 진심으로 환영합니다.");
		
		System.out.print("캐릭터 최대 수 입력 : ");
		int maxSize = sc.nextInt();
		
		Behavior b = new Behavior(maxSize);
		
		
		while(true) {
			System.out.print("1. 캐릭터생성 2. 캐릭터이동 3. 특정 캐릭터 조회 4. 전체조회 5. 캐릭터삭제 0. 게임종료 : ");
			int menu = sc.nextInt();
			if(menu == 0)
				break;
			else if(menu == 1){
				if(b.numChar == maxSize) {
					System.out.println("★★생성하실 수 있는 캐릭터 수가 초과되었습니다. 다음에 다시 이용해주세요.★★");
					continue;
				}
				System.out.println("생성하실 캐릭터의 직업을 선택해주세요. ");
				System.out.print("1. 전사 2. 마법사 3. 도적 4. 드루이드 5. 치유사 : ");
				int job = sc.nextInt();
				b.mkChar(job); 
			}else if(menu == 2){
//				b.allJobInfo();
//				System.out.print("캐릭터를 선택해주세요. : ");
//				int index = sc.nextInt();
				int index = b.allJobInfo("");
				System.out.print("X 위치를 입력해주세요. : ");
				int x = sc.nextInt();
				System.out.print("Y 위치를 입력해주세요. : ");
				int y = sc.nextInt();
				b.moveCharater(index, x, y);
				b.attack(index);		// 이동 후 적이 있으면 공격하게 함, 적이 없으면 자동적으로 실행되는 내용이 없음.
			} else if(menu == 3){
//				System.out.print("확인 하실 캐릭터를 입력해주세요 : ");
//				b.CharInfo(sc.nextInt());
				int index = b.allJobInfo("확인하실 ");
				b.CharInfo(index);
			}else if(menu == 4){
				b.allCharInfo();
			}else if(menu == 5){
				if(b.numChar == 0) {
					System.out.println("생성된 캐릭터가 존재하지 않습니다.");
					continue;
				}
				
//				b.allJobInfo();
//				System.out.print("삭제하실 캐릭터를 선택해주세요 : ");
//				int index = sc.nextInt();
				int index = b.allJobInfo("삭제하실 "); // 같은문장임
				b.rmChar(index);
			}else if(menu == 6){
				b.em.showEnemyMap();
			}
			
		}
				
			
//		System.out.print("1.");
		
		
		
		
	}

}




//				System.out.print("생성하실 캐릭터의 HP를 설정해주세요. : ");
//				int hp = sc.nextInt();
//				System.out.print("생성하실 캐릭터의 MP를 설정해주세요. : ");
//				int mp = sc.nextInt();