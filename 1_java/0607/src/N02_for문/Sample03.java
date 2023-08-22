/*
 * 이중 for문, 중첩 for문 @ 113p
 * for문 안에 for문이 있다는 거임 
 * 실제로 프로젝트를 할 때 이중 for문까지 쓸일은 많지 않음
 */
package N02_for문;

public class Sample03 {

	public static void main(String[] args) {
		
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=10; j++)
				System.out.print("*");
			System.out.println();
		}
		
//		해당 예제는 꼭 이중 for문 안 써도 됨!
//		for(int i=1; i<=50; i++) {
//			System.out.print("*");
//			if(i%10==0)
//				System.out.println();
//		}
	}
}
