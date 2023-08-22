package N02_다형성;

public class S01_Sample01 {

	public static void main(String[] args) {
		int a = 10;
		long b; // 좀더 큰 범위의 정수형 데이터타입
		b = a;
		double c = 3.14;
//		a = c; // (int) 명시적 형변환을 쓰지 않는 이상 안됨.
		c = a; // 이건 됨, 자동형변환, 묵시적 형변환
		/*
		 * 데이터타입이 담을 수 있는 크기가 기준
		 * 작은 걸 큰거로 변환할 경우에는 알아서 자동형변환
		 */
	}

}
