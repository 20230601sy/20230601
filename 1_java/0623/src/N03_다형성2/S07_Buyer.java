package N03_다형성2;

public class S07_Buyer {
	
	int money = 1000; // 원래 이런 건 생성자로 하는 게 낫습니다~ 근데 뭐 그냥 합시다~ㅋㅋㅋ
	int bonusPoint = 0;
	S07_Product[] cart = new S07_Product[10]; // 장바구니??라기보다는 구매이력
	int cnt = 0; // 장바구니에 담김 제품수
	
	public void buy(S07_Product p) {
		if(money < p.price) {
			System.out.println("비싸 못사");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + " 구매 완료");// 참조변수명만 쓰면 toString이 호출됨
		cart[cnt++] = p;
	}
	
	public void summary() {
		int sum = 0; // 그냥 1000-money; 인디 ㅡㅡ
		String itemList = "";
		for(int i=0; i<cnt; i++) {
			sum += cart[i].price;
			itemList += cart[i] + ((i==cnt-1)?" ":"/");
		}
		System.out.println(itemList + "구매 금액 총합 : " + sum + "만원");
	}
}
