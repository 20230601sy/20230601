package N03_컬렉션;

import java.util.ArrayList; // 교재처럼 *를 하면 import 추가를 계속 안 해도 되니까 편하지만, 나중에 배포할 때 불필요한 것까지 추가가 되는 문제가 생김  
import java.util.Collections;

public class S02_Sample {

	public static void main(String[] args) {
		ArrayList<Integer> al = new ArrayList<>(); // size는 미리 할당할 필요는 없음!
		al.add(5);
		al.add(4);
		al.add(2);
		al.add(0);
		al.add(1);
		al.add(3);
		ArrayList<Integer> al2 = new ArrayList<>(al.subList(1, 4));
		System.out.println(al2);
		
		System.out.println(al);
		Collections.sort(al);
		System.out.println(al);
		
		System.out.println(al.containsAll(al2));
		
		al.add(0);
		System.out.println(al.retainAll(al2)); // 공통된 교집합만 남기는 거!
		System.out.println(al);
		Collections.sort(al2);
		System.out.println(al2);
		System.out.println(al.contains(al2)); // 이거 왜 false임??? 질문 나왔으나 아직 해결 안됨
		
		al.clear();
		System.out.println("Empty? : " + al.isEmpty());
	}

}
