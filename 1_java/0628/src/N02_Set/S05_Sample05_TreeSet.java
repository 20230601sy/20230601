package N02_Set;

import java.util.TreeSet;

public class S05_Sample05_TreeSet {

	public static void main(String[] args) {
		TreeSet<String> t = new TreeSet<>();
		String from = "b";
		String to = "d";
		t.add("d"); t.add("ABC"); t.add("abc"); t.add("bad");
		t.add("a"); t.add("bBC"); t.add("abc"); t.add("cad");
		t.add("b"); t.add("cBC"); t.add("cbc"); t.add("dad");
		System.out.println(t);
		System.out.println(t.subSet(from, to)); // from 이상 to 미만, from 포함, to 미포함,
		
		System.out.println(t.headSet("b")); // head를 기준(지금은 "b")으로 전에 꺼 모두 출력, head가 포함 안됨!
		System.out.println(t.tailSet("b")); // head 이상 출력, head 포함됨!
		System.out.println(t.lower("b")); // 바로 작은 애
		System.out.println(t.higher("b")); // 바로 큰 애
		System.out.println(t.higher("db")); // 없으면 null로 주넹~
	}

}
