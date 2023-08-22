package N03_Map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class S01_Sample01 {

	public static void main(String[] args) {
		HashMap<String, Integer> map = new HashMap<>();
		map.put("고길동", 40);
		map.put("둘리", 10);
		map.put("또치", 13);
		System.out.println(map);
		/*
		 * {둘리=10, 또치=13, 고길동=40}
		 * 이전에 [ ]로 출력해준 거와 달리 { }로 출력해주는데, (이건 dictionary 형태에서는 다 이랬던듯)
		 * 일반적으로 key, value 형태의 데이터들은 eg. 서버에 데이터 주고 받을 때라든지~~~
		 * { key=value } 형태나 { key : value } 로 출력해준다심. Java에서도 한땀씩 직접 넣은 거임~ definition 보삼
		 */
		map.put("도우너", 13); // value 중복은 전혀 상관 없이 들어감~
		System.out.println(map);
		System.out.println(map.put("도우너", 50)); // put도 Object 리턴해줌, 교체하기 전 값 
		System.out.println(map); // key가 같은 아이는 value가 덮어씌워짐!!!
		System.out.println(map.remove("또치"));
		System.out.println(map);
		
		// put과 remove 가 값이 리턴해준다는 것의 장점은...
		System.out.println("중복 값의 기존 값 : " + map.put("도우너", 12)); // 이런 게 한 큐에 된다는 거임...
		System.out.println(map);
		map.put("둘리", map.put("도우너", map.get("둘리"))); // 값 바꿀 때 tmp를 안 쓰고 할 수가 있군ㅋㅋㅋㅋ 근데 이렇게까지 하려나 ㅋㅋㅋ
		System.out.println(map);
		
		System.out.println("map size : " + map.size());
		System.out.println(map.keySet());
		System.out.println(map.entrySet());
		
		System.out.println("방법1==========keySet이랑 Iterator 사용");
		Set<String> names = map.keySet();
		Iterator<String> it = names.iterator();
		while(it.hasNext()) {
			String key = it.next();
			int value = map.get(key);
			System.out.println(key + " : " + value);
		}
		System.out.println("방법2==================향상된 for문 사용");
		for(String k:map.keySet())
			System.out.println(k + " : " + map.get(k));
		
		System.out.println("방법3====================Iterator 사용");
		Set<Map.Entry<String, Integer>> entrySet = map.entrySet();
//		System.out.println(entrySet);
		Iterator<Map.Entry<String, Integer>> entryIt = entrySet.iterator();
		while(entryIt.hasNext()) {
			Map.Entry<String, Integer> entry = entryIt.next();
			String key = entry.getKey();
			int value = entry.getValue();
			System.out.println(key + " : " + value);
		}
	}
}
