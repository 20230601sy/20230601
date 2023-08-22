/*
 * 구구단 출력과 똑같은 방식으로 값 저장 후 출력
 * 1  6 11 16 21
 * 2  7 12 17 22
 * 3  8 13 18 23
 * 4  9 14 19 24
 * 5 10 15 20 25
 */
package N02_이차원배열;
public class Sample04 {
	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int k = 1;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				arr[j][i] = k; // 그냥 k 안 쓰고는 arr[i][j] = (i+1) + 5*j
				k++;
			}
		}
		
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr.length; j++){
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
	}
}
