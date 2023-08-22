// 1~100까지 짝수들의 합계
package N02_for문;
public class Test01 {
	public static void main(String[] args) {
		int sum = 0;
		for(int i=1; i<=100; i++) {
			if(i%2 == 0)
				sum += i;
		}
		
//		for(int i=2; i<=100; i+=2) { // 2씩 증가, 시작값 주의
//			sum += i;
//		}
		System.out.println("짝수합 : " + sum);
	}
}
