// arr의 값을 오름차순 정렬해서 출력하는 프로그램
package N02_배열;

import java.util.Arrays;

public class Sample07 {

	public static void main(String[] args) {
		int[] arr = {70, 30, 50, 90, 60};
		int i, j, tmp;
//		for(i=0; i<arr.length; i++) {
//			for(j=0; j<i; j++) {
//				if(arr[i] < arr[j]) {
//					tmp = arr[j];
//					arr[j] = arr[i];
//					arr[i] = tmp;
//				}
//			}
//		}
		
		// 강사님 설명한 걸로 프로그램 완성한 거
		for(i=0; i<arr.length-1; i++) {
			for(j=i+1; j<arr.length; j++) {
				if(arr[i] > arr[j]) { // 내림차순 정렬하려면 부등호 방향만 바꾸면 됨!
					tmp = arr[j];
					arr[j] = arr[i];
					arr[i] = tmp;
				}
			}
		}
		System.out.println(Arrays.toString(arr));
	}
}
