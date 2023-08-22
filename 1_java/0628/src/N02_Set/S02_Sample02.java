package N02_Set;

import java.util.HashSet;
import java.util.TreeSet;

public class S02_Sample02 {

	public static void main(String[] args) {
		HashSet<Integer> s = new HashSet<>();
//		Set<Integer> s = new HashSet<>(); // 다형성이 적용되기 때문에 이렇게 쓰기도 함, Set 종류가 많아서
		while(s.size()<6)
			s.add((int)(Math.random()*45)+1);
		System.out.println(s);
		
		TreeSet<Integer> t = new TreeSet<>(); // TreeSet을 쓰면 알아서 정렬해줌!
		while(t.size()<6)
			t.add((int)(Math.random()*45)+1);
		System.out.println(t);

	}

}
