package 형변환;

public class Sample02 {

	public static void main(String[] args) {
		double pi = 3.141592;
		double shortPi = Math.round(pi); // round는 소수 첫째자리(고정)에서 반올림됨
		System.out.println(shortPi);
		shortPi = Math.round(pi * 1000) / 1000.0;
		System.out.println(shortPi);
	}
}
