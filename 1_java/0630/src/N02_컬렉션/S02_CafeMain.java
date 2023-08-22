/*
 * map 컬렉션에 커피 메뉴들 관리
 * key : 커피 이름, value: MenuInfo 인스턴스
 * (기본 메뉴 3개 정도 넣어두기)
 * 메뉴 선택
 * [1] 메뉴보기, [2]메뉴조회, [3]메뉴추가,
 * [4] 메뉴삭제, [5]메뉴수정, [6]종료
 */
package N02_컬렉션;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class S02_CafeMain {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, S02_MenuInfo> menu = new HashMap<>();
		menu.put("아메리카노", new S02_MenuInfo("아메리카노", 2000, "커피", "진한 커피"));
		menu.put("라떼", new S02_MenuInfo("라떼", 3500, "커피", "?? 커피"));
		
		int choice;
		String menuChoice;
		System.out.println("카페 메뉴 관리 프로그램");
		while(true) {
			System.out.println("\n[1] 메뉴보기, [2] 메뉴조회, [3] 메뉴추가, "
								+ "[4] 메뉴삭제, [5] 메뉴수정, [6] 종료");
			System.out.print("어떤 걸 하시겠습니까? : ");
			choice = sc.nextInt();
			if(choice==6) {
				System.out.println("\n카페 메뉴 관리 프로그램 종료");
				break;
			} else if(choice==1) {
				showMenu(menu);
			} else if(choice==2) {
				menuChoice = pickMenu(menu, "조회");
				getMenu(menu, menuChoice);
			} else if(choice==3) {
				putMenu(menu);
				showMenu(menu);
			} else if(choice==4) {
				menuChoice = pickMenu(menu, "삭제");
				menu.remove(menuChoice);
			} else if(choice==5) {
				menuChoice = pickMenu(menu, "수정");
				reputMenu(menu, menuChoice);
			}
		}
	}
	
	public static void showMenu(HashMap<String, S02_MenuInfo> menu) {
		System.out.println();
		for(String key : menu.keySet())
			System.out.println(menu.get(key));
	}
	
	public static void getMenu(HashMap<String, S02_MenuInfo> menu, String name) {
		System.out.println();
		System.out.println(menu.get(name));
	}
	
	public static String pickMenu(HashMap<String, S02_MenuInfo> menu, String msg) {
		Scanner sc = new Scanner(System.in);
		ArrayList<String> menuList = new ArrayList<>();
		int cnt = 0;
		System.out.println();
		for(String key : menu.keySet()) {
			menuList.add(key);
			System.out.print("[" + (++cnt) + "] " + key + " ");
		}
		System.out.print("\n어떤 메뉴를 " + msg + "하시고 싶으십니까? : ");
		return menuList.get(sc.nextInt()-1);
	}
	public static void putMenu(HashMap<String, S02_MenuInfo> menu) {
		Scanner sc = new Scanner(System.in);
		System.out.println("\n추가할 메뉴의 정보를 입력해주세요.");
		System.out.print("메뉴 이름 : ");
		String name = sc.next();
		if(menu.containsKey(name)) {
			System.out.println("기존에 있는 메뉴입니다. 조회 후 필요 시 수정해주세요.");
			return;
		}
		System.out.print("메뉴 가격 : ");
		int price = sc.nextInt();
		System.out.print("메뉴 종류 : ");
		String group = sc.next();
		sc.nextLine();
		System.out.print("메뉴 설명 : ");
		String type = sc.nextLine();
		menu.put(name, new S02_MenuInfo(name, price, group, type));
	}
	public static void reputMenu(HashMap<String, S02_MenuInfo> menu, String name) {
		Scanner sc = new Scanner(System.in);
		System.out.println();
		System.out.println(menu.get(name).showInfo2());
		System.out.print("수정할 정보를 선택해주세요. : ");
		int ch = sc.nextInt();
		String newName = name;
		switch(ch) {
			case 1:
				System.out.print("수정할 메뉴 이름 : ");
				newName = sc.next();
				menu.get(name).name = newName; 
				menu.put(newName, menu.get(name));
				menu.remove(name);
				break;
			case 2:
				System.out.print("수정할 메뉴 가격 : ");
				menu.get(name).price = sc.nextInt();
				break;
			case 3:
				System.out.print("수정할 메뉴 종류 : ");
				menu.get(name).group = sc.next();
				break;
			case 4:
				System.out.print("수정할 메뉴 설명 : ");
				sc.nextLine();
				menu.get(name).type = sc.nextLine();
				break;
		}
		getMenu(menu, newName);
	}
}
