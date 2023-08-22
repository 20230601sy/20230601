package 평가;

public class MathEx {
	// 점수 range 0~100점 전제함
	// max==-1 이거나 min==101이면 전달해준 배열의 길이가 0이거나 점수가 잘못 입력된 상황임
	public int max(int[] arr) {
		int max = -1;
		for(int i=0; i<arr.length; i++) {
			if(max < arr[i])
				max = arr[i];
		}
		return max;
	}
	public int min(int[] arr) {
		int min = 101;
		for(int i=0; i<arr.length; i++) {
			if(min > arr[i])
				min = arr[i];
		}
		return min;
	}
}
