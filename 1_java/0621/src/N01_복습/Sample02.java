package N01_복습;

//import java.util.Arrays;

public class Sample02 {

	public static void main(String[] args) {
		int[] arr = {1, 2, 3};
//		System.out.println(arr + " : " + Arrays.toString(arr));
//		arr = new int[]{4, 5, 6};
//		System.out.println(arr + " : " + Arrays.toString(arr));
		/*
		 * 레퍼런스 변수
		 * 배열, 객체 주소값을 가리키고 있는 상태 
		 * 얕은 복사 vs 깊은 복사 // 배열이나 객체를 사용할 때는 연결시켜서 사용할 것인지 내용이 독립적으로 포함되어야 하는지 염두 필요
		 */
		Sample01[] s = new Sample01[6];
		for(int i=0; i<s.length; i++) {
			s[i] = new Sample01();
		}
	}
}
