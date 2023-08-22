package N02_Set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class S06_Sample06 {

	public static void main(String[] args) {
		ArrayList<Integer> nums = new ArrayList<>();
		for(int i=0; i<10; i++)
			nums.add((int)(Math.random()*10)+1);
		for(int i=0; i<5; i++)
			nums.add(nums.get((int)(Math.random()*10)+1));
		System.out.println("중복 제거 전 : " + nums);
		
		HashSet<Integer> s = new HashSet<>();
//		for(int n : nums)
//			s.add(n);
//		System.out.println(s);
		
		Iterator<Integer> it = nums.iterator();
		while(it.hasNext()) {
			if(!(s.add(it.next())))
				it.remove();
		}
		System.out.println("중복 제거 후 : " + nums);
		System.out.println(s);
	}

}
