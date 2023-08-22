/*
 * 별찍기랑 똑같은 방식으로 값 저장 후 출력
 *   1
 *   2  3
 *   4  5  6
 *   7  8  9 10
 *   11 12 13 14 15
 */
package N02_이차원배열;
public class Sample03 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int k = 1;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<=i; j++){
				arr[i][j] = k;
				k++;
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
