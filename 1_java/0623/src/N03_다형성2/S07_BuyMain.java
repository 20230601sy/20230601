package N03_다형성2;

public class S07_BuyMain {

	public static void main(String[] args) {
		
		S07_Buyer b = new S07_Buyer();
		b.buy(new S07_Tv());
		b.buy(new S07_Computer());
		b.buy(new S07_Audio());
		
		b.summary();
		System.out.println("잔액 : " + b.money + "만원, 적립금 : " + b.bonusPoint +"점");
	}

}
