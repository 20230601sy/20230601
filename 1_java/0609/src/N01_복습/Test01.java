// 교재 125p 4-3번, 4-4번
package N01_복습;

public class Test01 {

	public static void main(String[] args) {
		int result = 0;
		for(int i=1; i<=10; i++)
			for(int j=1; j<=i; j++)
				result += j;
		System.out.println("교재 125p 4-3번 결과 : " + result);
		
		int idx = 0;
		int sum = 0;
		while(sum<100) {
			idx++;
			sum += (idx%2==1)? idx : -idx;
		}
		System.out.println("교재 125p 4-4번 답안 : " + idx + "까지 더해야 총합이 100 이상이 됩니다.");

		// if 안 쓰고 하는 거
		idx = 0;
		sum = 0;
		int sw = 1;
		while(sum<100) {
			idx++;
			sum += idx*sw;
			sw = -sw;
		}
		System.out.println("교재 125p 4-4번 답안 : " + idx + "까지 더해야 총합이 100 이상이 됩니다.");

		// if 안 쓰고 하는 거, 변수 안 쓰고 할 수는 있네... (1 0) → (1 -1) 니까 2*(i%2)-1
		idx = 0;
		sum = 0;
		while(sum<100) {
			idx++;
			sum += idx*(2*(idx%2)-1); // 근데 이러면 알아보기 복잡하잖아ㅜ
		}
		System.out.println("교재 125p 4-4번 답안 : " + idx + "까지 더해야 총합이 100 이상이 됩니다.");
	}
}
