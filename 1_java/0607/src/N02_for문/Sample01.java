package N02_for문;

public class Sample01 {

	public static void main(String[] args) {
		for(int i=0; i<5; i++) {
			System.out.println("hello");
		}
		/*
		 * i 조건식 	i<5 실행코드
		 * 0 T		1번 실행
		 * 1 T		2번 실행
		 * ...
		 * 5 F		반복탈출
		 */
		
		for(int i=0; i<5; i++) { // i를 꼭 여기서 새로 선언해야 하는 것은 아님, i의 가용 범위가 달라짐
			System.out.println(i);
		}
		// System.out.println(i); 반복문에서 i를 선언하면, for문 바깥에서 i 사용은 error 발생
		
		int i;
		for(i=0; i<5; i++) { // i를 반복문 밖에서 사용하려면 먼저 선언해야 함
			System.out.println(i);
		}
		System.out.println("반복문 탈출 후 i : " + i);
		
		// 증감식도 내마음대로 써도 됨 i++ 대신 i=i+1 이나 i+=1 를 써도 동일함
		// 대부분은 1씩 증감이긴한데, 아닌 경우도 있으니 비슷하게 사용하면 됨
		for(i=0; i<10; i+=3) {
			System.out.println(i);
		}
		System.out.println("반복문 탈출 후 i : " + i);
		
		// 반복할 코드가 1줄이면 {} 생략 가능
		for(int j=0; j<5; j++)
			System.out.println(j);
	}

}
