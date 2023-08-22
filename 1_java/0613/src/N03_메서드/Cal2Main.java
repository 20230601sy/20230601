package N03_메서드;

public class Cal2Main {

	public static void main(String[] args) {
		Cal2 c = new Cal2();
		
		int a = 10, b = 20;
		c.add(a, b); // 출력하라는 게 아무것도 없으니 그냥 실행되고 종료됨
		c.showResult(c.add(a, b));
		c.showResult(c.sub(a, b));
		c.showResult(c.mul(a, b));
		c.showResult(c.div(a, b)); // 같은 이름의 매개변수 다른 거는 생성 가능!
		
		c.a = 1;
		c.b = 5;
		System.out.println("===============");
		System.out.println(c.add(a, b));
	}
}