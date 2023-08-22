package N03_제네릭;

import java.util.ArrayList;

class Student<T, E>{ // T는 type의 앞글자를 따왔음 뭐 걍 쓰고 싶은 거 써도 됨, 제네릭 갯수 제한은 없음, 여러개 쓰면 됨
	T studentId;
	E age;

	public Student(T studentId) {
		this.studentId = studentId;
	}
	
	public E getAge() {
		return age;
	}
	
}

public class S01_Sample {

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		int sum;
		list.add(111);
		list.add(222);
		list.add("aaa"); // 숫자열 외에 것도 들어감!, Object형으로 변환되어 다 들어갈 수 있음
		sum = (Integer)list.get(0) + (Integer)list.get(1); // 형변환 필요! 들어가 있는 게 Object형이니까...
		
		ArrayList<Integer> list2 = new ArrayList();
		list2.add(111);
		list2.add(222);
//		list2.add("aaa"); // 숫자열 외에 것은 못 들어감!
		sum = list2.get(0) + list2.get(1); // 형변환 필요 없음!
		/*
		 * 제네릭 설정 시 이점
		 * 1. 강한 타입 체크: 원치 않는 타입의 데이터를 못 넣게 방지함
		 * 2. 형변환 불필요
		 * 어떨 때는 숫자를 처리하고 싶을 때가 있고 어떨 때는 문자를 처리하고 싶을 때도 활용 가능!
		 */
		Student<String, Integer> s1 = new Student("무지개반 12번");
		Student<Integer, Integer> s2 = new Student(20203391); // 클래스를 한 번만 만들어도 된다는 거!!!
		Student s = new Student(3333); // 이건 컬렉션과 동일하게 Object형으로 변환되어 들어감~
	}

}
