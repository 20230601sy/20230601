package N03_break문;

public class Sample02 {

	public static void main(String[] args) {
		while(true) {
			for(int i=1; i<=5; i++) {
				System.out.println(i);
				if(i==3)
				break; // 해당 break는 for문만 나가는 것이므로 while의 무한루프는 벗어나지 않음
			}
		}
	}
}
