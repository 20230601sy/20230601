package N02_API;

public class S02_Main {

	public static void main(String[] args) {
		Integer num1 = new Integer(10);
		Integer num2 = new Integer(20);
		Integer num3 = new Integer(10);
		int n1 = num1.intValue();
		int n2 = num2.intValue();
		
		int r1 = n1 + n2;
		int r2 = num1 + num2;
		int r3 = n1 + num1; // 다 연산된다는 거~~

	}

}
