// 442p 예제 
package N01_컬렉션;

import java.util.HashMap;
import java.util.Map;

public class S01_Sample01 {

	public static void main(String[] args) {
		String[] data = {"A", "B", "C", "A", "A", "B", "B", "C", "A"};
		HashMap<String, Integer> map = new HashMap<>();
		
		for(String d : data)
//			map.put(d, map.get(d)==null?1:map.get(d)+1);
			map.put(d, map.containsKey(d)? map.get(d)+1 : 1); // containsKey로 설명하심
		System.out.println(map);
		
		for(String k : map.keySet())
			System.out.println(k + " : " + printBar('★', map.get(k))+ " " + map.get(k));
		
	}
	
	public static String printBar(char ch, int value) {
		String bar = "";
		for(int i=0; i<value; i++)
			bar += ch;
		return bar;
	}

}
