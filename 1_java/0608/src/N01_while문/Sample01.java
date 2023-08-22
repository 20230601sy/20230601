// 1~100까지 합
package N01_while문;

public class Sample01 {

	public static void main(String[] args) {
		int i = 1;
		int sum=0;
		while(i<=100) {
			sum += i;
			i++;
		}
		System.out.println("합계 : " + sum);
	}

}
