// 구구단 2단부터 5단까지 출력
package N02_for문;

public class Sample04 {

	public static void main(String[] args) {
//		1줄로 계속 출력됨
//		for(int i=2; i<=5; i++) {
//			for(int j=1; j<=9; j++) {
//				System.out.println(j + "*" + i + "=" + j*i);
//			}
//		}
		
//		같은 단끼리만 가로 한 줄씩 출력
//		for(int i=2; i<=5; i++) {
//			for(int j=1; j<=9; j++) {
//				System.out.print(j + "*" + i + "=" + j*i + " ");
//			}
//			System.out.println();
//		}
		
//		같은 단이 세로로 출력되게 for문 순서와 출력문 index를 수정
		for(int i=1; i<=9; i++) {
			for(int j=2; j<=5; j++) {
//				System.out.print(j + "*" + i + "=" + j*i + "\t");
				System.out.printf("%d*%d = %2d │ ",j, i, j*i);
			}
			System.out.println();
		}
	}
}
