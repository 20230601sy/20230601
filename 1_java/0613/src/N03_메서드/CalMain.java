package N03_메서드;

public class CalMain {

	public static void main(String[] args) {
		Cal c = new Cal();
		c.hello();
		
		int a = 10, b = 20;
		c.add(a, b); // 인수, argument, 따지고 보면 여기 a, b는 값을 보내는 거임 c.add(10, 20), cal 클래스 add 매서드의 지역 변수는 다름
		c.sub(a, b);
		c.mul(a, b);
		c.div(a, b);
		c.div(a, 0);
		c.abs(a, b);
		
		int sum = 0;
		for(int i=1; i<=10; i++)
			sum = c.add1(sum, i);
		System.out.println(sum);
	}

}
