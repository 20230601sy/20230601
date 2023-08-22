package N02_Set;

import java.util.HashSet;

import N01_컬렉션.S09_Person;

public class S03_PersonMain {

	public static void main(String[] args) {
		HashSet<S09_Person> s = new HashSet<>();
		s.add(new S09_Person("고길동", 40));
		s.add(new S09_Person("둘리", 10));
		s.add(new S09_Person("고길동", 40)); // 주소값이 다르니까 다른 인스턴스라네...
		System.out.println(s);
		
		S09_Person p = new S09_Person("고길동", 40);
		s.add(p);
		s.add(p); // 이 객체는 중복으로 안 들어감
		
		// 내용 확인해서 추가를 할지 안할지 결정하려면 hashCode와 equals 메서드를 오버라이딩해줘야 했던 거!
		
		s.add(new S09_Person("고길동", 40));
		System.out.println(s);
	}

}
