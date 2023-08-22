package N01_컬렉션;

import java.util.ArrayList;
import java.util.Collections;

public class S09_PersonMain2_Comparable {

	public static void main(String[] args) {
		ArrayList<S09_Person> al = new ArrayList<>();
		al.add(new S09_Person("고길동", 40));
		al.add(new S09_Person("둘리", 10));
		al.add(new S09_Person("마이콜", 15));
		System.out.println(al);
		
		Collections.sort(al);
		System.out.println(al);
		Collections.reverse(al); // reverse는 정렬이랑은 상관 없음 그냥 꺼꾸로라서 내림차순 하고 싶으면 먼저 (오름차순) 정렬한 다음 리버스해야 함!
		System.out.println(al);
	}
}
