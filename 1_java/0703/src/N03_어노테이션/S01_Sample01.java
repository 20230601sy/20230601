package N03_어노테이션;

import java.util.ArrayList;

class Acc{
	@Deprecated
	public void add() { // 이제 이거 구리니까 쓰지말고 upgradeAdd() 쓰셈 
		System.out.println("더하기");
	}
	public void upgradeAdd() {
		System.out.println("더 좋은 더하기");
	}
}
public class S01_Sample01 {

	public static void main(String[] args) {
		Acc a = new Acc();
		a.add(); // 주석을 아무리 달아놔도 구현 코드를 찾아가서 보지는 않는다는 거! 그래서 어노테이션 넣으면! 취소선(삭선ㅋㅋㅋ) 끄임! 
		a.upgradeAdd();
		
		
		// 괄호 안에 어떤 거를 안 보이게 할 건지 써줌, 여러 개 하려면 { } 로 묶음, 자바에서 자동으로 넣으라고 알려주기도 함 
		@SuppressWarnings("unchecked")
		ArrayList al = new ArrayList<>(); // 노란줄 떠있는 게 거슬릴 때! 클래스, 메서드, 변수 위에 달면 관련된 항에 어노테이션 달아주면 됨!
	}
}