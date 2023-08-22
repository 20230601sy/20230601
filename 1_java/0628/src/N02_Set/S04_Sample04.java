package N02_Set;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;

public class S04_Sample04 {

	public static void main(String[] args) {
		HashSet<Integer> setA = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5));
		HashSet<Integer> setB = new HashSet<>(Arrays.asList(4, 5, 6, 7, 8));
		HashSet<Integer> setHab = new HashSet<>();
		HashSet<Integer> setKyo = new HashSet<>();
		HashSet<Integer> setCha = new HashSet<>();
		System.out.println("setA : " + setA);
		System.out.println("setB : " + setB);
		
		Iterator<Integer> it = setA.iterator();
		while(it.hasNext()) {
			int tmp = it.next();
			setHab.add(tmp);
			if(setB.contains(tmp))
				setKyo.add(tmp);
			else
				setCha.add(tmp); // A-B
		}
		it = setB.iterator();
		while(it.hasNext())
			setHab.add(it.next());
		System.out.println("setHab : " + setHab);
		System.out.println("setKyo : " + setKyo);
		System.out.println("setCha : " + setCha);
		
		HashSet<Integer> test = new HashSet<>();
		for(Integer a: setA) // Iterator는 약간 뭐시기 그 반복을 돌리기 위함인 듯
			test.add(a);
		for(Integer b: setB)
			test.add(b);
		System.out.println("test : " + test);
	}

}
