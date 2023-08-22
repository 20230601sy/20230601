package N03_컬렉션;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class S01_Sample {

	public static void main(String[] args) {
		
		ArrayList user = new ArrayList();// <E> 제너릭이라는 건 나중에 설명한다심
		user.add("홍길동");
		user.add(123);
		user.add("abc");
		user.add("qwer");
		user.add("abc");
		System.out.println(user); // toString 호출 [홍길동, abc, qwer]
		
		for(int i=0; i<user.size(); i++) { // 배열의 length가 아니라 .size() 임!
			System.out.print(user.get(i) + " "); // 배열이랑 유사한데 조금조금 다른 거임!
		}
		System.out.println();
		
		user.add(2, "asdf"); // 중간에 껴넣고 싶을 때
		System.out.println(user);
		
		// 오버로딩된 remove는 서로 리턴타입이 다름!
		
		System.out.println(user.remove("abc")); // 내용으로 삭제 public boolean remove(Object o)
		System.out.println(user);
		System.out.println(user.remove(3)); // 인덱스로 삭제 public E remove(int index) 인덱스로 삭제하면, 삭제한 방의 데이터를 출력해줌
		System.out.println(user);
		
//		ArrayList user = new ArrayList(); <E> 제너릭이라는 거 설명하시려는 듯
//		String name = user.get(0); 타입 지정 안 하면, 이런 게 안되는데, 무조건 모든 클래스에 상속되는 Object로 인식함.
		String name = (String) user.get(0); // 업캐스팅은 자동으로 됐지만, 다운캐스팅은 형변환 해야 한다는 거!
		// 이럴 거면 걍 처음에 ArrayList 만들 때 형식을 지정해서 알려주겠다고 하는 거
//		ArrayList<String> aList = new ArrayList<String>(); // 뒤에 <> 사이에 String은 안 써도 됨
		ArrayList<String> aList = new ArrayList<>(); // 일반적으로는 안 쓰는 걸 더 권장!
		aList.add("haha");
		String str = aList.get(0); // 형변환 없이 가능하다는 거!
		
		String[] data = {"123", "456", "789"};
		ArrayList<String> al2 = new ArrayList<>(Arrays.asList(data)); // 일반적으로는 안 쓰는 걸 더 권장!
		System.out.println(al2);
		al2.sort(Comparator.naturalOrder());
		System.out.println(al2);
		al2.sort(Comparator.reverseOrder());
		System.out.println(al2);
	}

}
