package N02_다형성;

public class S07_Buyer {
	
	int money = 1000; // 원래 이런 건 생성자로 하는 게 낫습니다~ 근데 뭐 그냥 합시다~ㅋㅋㅋ
	int bonusPoint = 0;
	
	public void buy(S07_Product p) {
		if(money < p.price) {
			System.out.println("비싸 못사");
			return;
		}
		money -= p.price;
		bonusPoint += p.bonusPoint;
		System.out.println(p + " 구매 완료");// 참조변수명만 쓰면 toString이 호출됨
	}
}
