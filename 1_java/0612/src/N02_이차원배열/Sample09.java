package N02_이차원배열;

import java.util.Arrays;

public class Sample09 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3, 4};
		int size = 7;
		int[] arr2 = Arrays.copyOf(arr, size);
		System.out.println(Arrays.toString(arr2));
		int[] arr3 = Arrays.copyOfRange(arr, 1, 3);		
		System.out.println(Arrays.toString(arr3));
	}

}
