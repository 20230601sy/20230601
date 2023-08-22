/*
 * 주문할 음식과 가격을 계속 입력받음 (exit 입력하면 종료)
 * 동일한 음식을 주문하면 가격이 추가됨
 * 종료되면 주문한 음식과 가격들을 전체 출력해줌
 * ex)
 * 음식 입력: 피자
 * 가격 입력: 12000
 * 음식 임력: 치킨
 * 가격 입력: 21000
 * 음식 입력: 피자
 * 가격 입력: 22000
 * ----------------
 * 주문 내역
 * 피자 - 34000
 * 치킨 - 21000
 */
package N01_HW;

import java.util.HashMap;
import java.util.Scanner;

public class S05_Sample05_2 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		HashMap<String, Integer> map = new HashMap<>();
		String menu;
		int price;
		while(true) {
			System.out.print("음식 입력 : ");
			menu = sc.nextLine();
			if(menu.equalsIgnoreCase("exit"))
				break;
			System.out.print("가격 입력 : ");
			price = sc.nextInt(); // 이건 예외처리 비스무리 해줘야 할 듯
			sc.nextLine();
			map.put(menu, price + (map.containsKey(menu)?map.get(menu):0));
		}
		System.out.println("====================");
		if(map.isEmpty()) {
			System.out.println("주문 내역 없음");
			return;
		}
		
		System.out.println("주문 내역");
		for(String k : map.keySet())
			System.out.println(k + "	- " + map.get(k));

	}

}
// 딱히 메서드화시킬 게... 뭐 해야 한다면 할 수야 있지만 지금은 패스~