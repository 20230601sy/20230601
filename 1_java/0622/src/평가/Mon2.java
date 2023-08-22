package 평가;

public class Mon2 {

	public static void main(String[] args) {
		
		int[] scores = {90, 80, 67, 100, 89, 76, 56, 78, 88, 95}; // 훈련생의 점수를 기억하는 배열 
		MathEx m = new MathEx();		// MathEx 객체 생성
		int max = m.max(scores);		// 최고점수 구하는 메서드 호출 
		int min = m.min(scores);		// 최저점수 구하는 메서드 호출
		
		System.out.println("[실행 결과]\n");
		System.out.println("최대값 : "+max);
		System.out.println("최소값 : "+min);
	}

}

