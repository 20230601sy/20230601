// 114p 예제, 별찍기, 반복문의 기초 예제, 모든 java 책 반복문에 다 있을 거임. 그니까 다 할 거임 ㄷㄷ
package N02_for문;

import java.util.Scanner;

public class Sample05 {

	public static void main(String[] args) {
		// 기본 삼각형 별찍기
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=i; j++)
				System.out.print("*");
			System.out.println();
		}
		
		// 거울상
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i<=5-j)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		
		// 역순
		for(int i=1; i<=5; i++) {
			for(int j=5; j>=i; j--) // int j=i; j<=5; j++ 라든지 다 되긴 하지만 배열이라는 차원에서는 int j=1; j<=6-i; j++ !!!
				System.out.print("*");
			System.out.println();
		}
		
		// 역순 거울상1 for문 안에 for문 2개
		for(int i=1; i<=5; i++) {
			for(int j=1; j<i; j++)
				System.out.print(" ");
			for(int j=1; j<=6-i; j++)
				System.out.print("*");
			System.out.println();
		}
		
		// 역순 거울상2 이중 for문 안에 if문
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				if(i>j)
					System.out.print(" ");
				else
					System.out.print("*");
			}
			System.out.println();
		}
		
		// 역순 거울상 + 삼항연산자
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++)
				System.out.print(i>j ? " " : "*");
			System.out.println();
		}
		
		/* 모래시계
		 * int n = -1;
		 * for(; ; j+=n)
		 * if 처리해서 n=-n; 해주면 가능 blah blah 못들은 걸로 해요...헤헷
		 * 
		 * 1 → 0, 1~5 → 1~i-1, i~6-i, 6-i+1~5
		 * 2 → 1, 2~4
		 * 3 → 1~2, 3
		 * 4 → 1, 2~4 → 1~6-i-1, 6-i~i, i+1~5
		 * 5 → 0, 1~5
		 */
		for(int i=1; i<=5; i++) {
			for(int j=1; j<=5; j++) {
				int k = i;
				if(i > 6-i)
					k = 6-i;
				if(k<=j && j<=6-k)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}
		
		Scanner sc = new Scanner(System.in);
		System.out.print("n? : ");
		int n = sc.nextInt();
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				int k = i;
				if(i > n+1-i)
					k = n+1-i;
				if(k<=j && j<=n+1-k)
					System.out.print("*");
				else
					System.out.print(" ");
			}
			System.out.println();
		}

	}
}
