// 배열 크기를 유동적으로 저장 가능

package N02_배열;

import java.util.Arrays;
import java.util.Scanner;

public class Sample04 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.print("인원수 입력 : ");
		int[] arr = new int[sc.nextInt()];
		for(int i=0; i<5; i++) {
			System.out.print((i+1) + "번째 점수 입력 : ");
			arr[i] = sc.nextInt();
		}
		System.out.println("====결과 확인====");
		System.out.println(Arrays.toString(arr));
	}

}
