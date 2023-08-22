package N02_이차원배열;

import java.util.Arrays;

public class Sample01 {
	public static void main(String[] args) {
		int[][] arr = {{1,2,3},{4,5,6}}; // 이차원배열 arr = new int[2][3]
		int[][] arr1 = {
				{1,2,3},
				{4,5,6}
				}; // 가독성을 위해서 엔터. 나중에 자바스크립트도 이런 식으로 쓴다심.
		//출력은 이중 for문
		System.out.println("이차원 배열 arr 행 개수 : " + arr.length);
		System.out.println("이차원 배열 arr 열 개수 : " + arr[0].length);	// 꼭 0을 써야 하는 것은 아님, 그냥 하나 넣으면 그 다음 길이가 나오는 거.
		for(int i=0; i<arr.length; i++) {
			for(int j=0; j<arr[0].length; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
		for(int i=0; i<arr.length; i++)
			System.out.println(Arrays.toString(arr[i]));
	}
}