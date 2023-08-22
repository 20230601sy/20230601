package N01_컬렉션;

import java.util.ArrayList;
import java.util.Iterator;

public class S07_IteratorMain {

	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("뭐할까?");
		al.add("뭐하지?");
		al.add("뭐해요?");
		
		Iterator<String> it = al.iterator();
//		al.add("여기 추가는 안됨!"); iterator에 cursor랑 해서 thread하면 Sync를 맞춰줘야 해서 안됨...
		while(it.hasNext())
			System.out.println(it.next());
		System.out.println(al);
		
		it = al.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
			it.remove();
		}
		System.out.println(al);
	}

}
