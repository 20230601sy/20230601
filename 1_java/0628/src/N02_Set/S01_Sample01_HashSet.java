package N02_Set;

import java.util.Arrays;
import java.util.HashSet;

public class S01_Sample01_HashSet {

	public static void main(String[] args) {
		HashSet<String> s = new HashSet<>();
		s.add("아아아");
		s.add("테스트1");
		s.add("테스트2");
		
		System.out.println(s); // 인덱스 번호 못 넣음 그런 거 없음!, 순서 출력은 매번 다를 수 있음
		s.add("테스트 해볼까?");
		s.add("테스트2");
		System.out.println("테스트2 추가 해볼까? : " + s.add("테스트2"));
		System.out.println(s);
		
		s.addAll(Arrays.asList("이것도 해보자", "테스트3"));
		System.out.println(s);
		
		s.remove("아아아"); // 인덱스로 지우는 게 없지~
		System.out.println(s);
	}

}
