package N04_인터페이스;

public class S02_CalcMain {

	public static void main(String[] args) {
		S02_NormalCalc c = new S02_NormalCalc();
		System.out.println("5 + 10 = " + c.add(5, 10));
		System.out.println("20 - 10 = " + c.add(20, 10));
//		System.out.println("5 * 3 = " + c.mul(5, 3)); // static 메서드는 상속과 상관 없음
		System.out.println("5 * 3 = " + S02_Calculator.mul(5, 3));
	}

}
