package N04_인터페이스;

public interface S02_Calculator {
	
	public int add(int a, int b);
	public default int sub(int a, int b) {
		return a-b;
	}
	public static int mul(int a, int b) {
		return a*b;
	}
}
