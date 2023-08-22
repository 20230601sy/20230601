package N04_쓰레드;

public class S03_Sample03 {

	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		
		for(int i=0; i<1000; i++)
			System.out.print("☆");

		long endTime = System.currentTimeMillis();
		System.out.println("첫번째 반복문 소요시간 : " + (endTime - startTime)); // 대략 6~10초 걸림
		
		for(int i=0; i<1000; i++)
			System.out.print("★");

		endTime = System.currentTimeMillis();
		System.out.println("전체 소요시간 : " + (endTime - startTime)); // 대략 10~17초 걸림
	}

}
