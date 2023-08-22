package N02_다형성;

public class S07_BuyMain {

	public static void main(String[] args) {
		
		S07_Buyer b = new S07_Buyer();
		b.buy(new S07_Tv());
		b.buy(new S07_Computer());
		System.out.println("잔액 : " + b.money + "만원, 적립금 : " + b.bonusPoint +"점");
		
		System.out.println(b.toString()); 	// 이건 오버라이딩이 없으니 그냥 주소값이 나옴
		System.out.println(b);				// b라고만 써도 b.toString()과 동일한 값 출력함!
	}

}
