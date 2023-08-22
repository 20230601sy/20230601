package N01_컬렉션;

import java.util.ArrayList;
import java.util.Comparator;

public class S09_PersonMain {

	public static void main(String[] args) {
		ArrayList<S09_Person> al = new ArrayList<>();
		al.add(new S09_Person("고길동", 40));
		al.add(new S09_Person("둘리", 10));
		al.add(new S09_Person("마이콜", 15));
		al.sort(Comparator.comparingInt(S09_Person::getAge)); // 클래스명 :: 메서드명, 람다할 때 할 거라심
		System.out.println(al);
		al.sort(Comparator.comparingInt(S09_Person::getAge).reversed());
		System.out.println(al);
		
		
	}

}
