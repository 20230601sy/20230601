package N02_열거타입;

public class S01_CardMain {

	public static void main(String[] args) {
		if(S01_Card.CLOVER == S01_Card.TWO)
			System.out.println("같음"); // 내용물을 가지고 비교하기 때문에 "같음"으로 출력
		else
			System.out.println("다름");
		// 생각해보면 CLOVER랑 TWO는 의미상 다른 것이기 때문에 다르다고 해야 함
		
//		if(S01_Card.Kind.CLOVER == S01_Card.Value.TWO) // 애초에 종류가 다르기 때문에 비교가 안됨 
	}

}
