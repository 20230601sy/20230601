/* 
 * 1~25까지 5-by-5에 값을 달팽이로 저장하고 출력
 *    1  2  3  4  5
 *   16 17 18 19  6
 *   15 24 25 20  7
 *   14 23 22 21  8
 *   13 12 11 10  9
 */
package N02_이차원배열;

import java.util.Scanner;

public class Sample07 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("int size 입력 : ");
		int size = sc.nextInt();
		int[][] arr = new int[size][size];
		int i=0, j=0;
//		int k=1;
//		int inc = 1;
//		int cnt=size-1;
//		while(cnt>0){
//			for(int x=0; x<cnt; x++) {
//				arr[i][j] = k;
//				j = j + inc;
//				k++;
//			}
//			for(int x=0; x<cnt; x++) {
//				arr[i][j] = k;
//				i = i + inc;
//				k++;
//			}
//			if(inc == -1) {
//				cnt = cnt-2;
//				i = i - inc;
//				j = j - inc;
//			}
//			inc = -inc;
//		}
//		if(size%2==1) // n-1, n-1 로 나누니까 홀수일 때 마지막이 항상 비는군. 강사님처럼 n, n-1 형태로 하든가. 
//			arr[(size-1)/2][(size-1)/2] = size*size;
//		다 귀찮으면 아래처럼 next i, j를 설정해주는 방식으로 하면 됨 ㅎㅎ
		for(int k=1; k<=size*size; k++) {
			arr[i][j] = k;
			if(i<=j+1 && i+j<size-1)
				j++;
			else if(i+j>=size-1 && i<j)
				i++;
			else if(i>=j && i+j>size-1)
				j--;
			else if(i+j<=size-1 && i>j+1)
				i--;
		}
		
		for(i=0; i<arr.length; i++){
			for(j=0; j<arr[i].length; j++){
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
