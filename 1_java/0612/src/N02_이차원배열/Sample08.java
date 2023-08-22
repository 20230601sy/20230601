package N02_이차원배열;

import java.util.Arrays;

public class Sample08 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int[][] arr2 = {
				{1, 2, 3},
				{4, 5, 6}
		};
		System.out.println(Arrays.toString(arr));
		System.out.println(Arrays.deepToString(arr2)); // 이차원 배열을 출력시키기 위한 명령어
		
		String[] str1 = {"abc", "def"};
		String[] str2 = {"abc", "ghi"};
		System.out.println(str1[0] + " " + str2[0]);
		System.out.println(str1 == str2); // 주소값이니까 false
		System.out.println(str1[0] == str2[0]); // 값비교니까 true
		System.out.println(str1[0].equals(str2[0])); // 지금은 왜 이게 필요할까 싶지만 나중에 객체 사용할 때 필요함
		
	}
}
