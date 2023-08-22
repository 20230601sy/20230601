// 1~25까지 5-by-5에 값을 저장하고 출력
package N02_이차원배열;

import java.util.Arrays;

public class Sample02 {

	public static void main(String[] args) {
		int[][] arr = new int[5][5];
		int k = 1;
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				arr[i][j] = k;
				k++;
				System.out.print(arr[i][j]+"	");
			}
			System.out.println();
		}
		for(int i=0; i<arr.length; i++){
			for(int j=0; j<arr[i].length; j++){
				System.out.printf("%3d", arr[i][j]);
			}
			System.out.println();
		}
		for(int i=0; i<arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
	}
}
