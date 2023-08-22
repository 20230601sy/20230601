package N02_배열;

public class Sample02 {

	public static void main(String[] args) {
		int[] arr = {10, 20, 30, 40, 50};
		// 배열 arr에 저장된 숫자들의 합계를 출력
		int sum = 0;
		for(int i=0; i<5; i++)
			sum += arr[i];
		System.out.println("합계 : " + sum);

	}

}
