package N01_람다;

import java.util.ArrayList;
import java.util.HashMap;

public class S02_Sample02 {

	public static void main(String[] args) {
		ArrayList<Integer> list = new ArrayList<>();
		for(int i=0; i<10; i++)
			list.add(i);
		for(Integer num:list)
			System.out.print(num + " ");
		// 이렇게 해왔지만... 이제 람다를 배웠으니 컬렉션을 편하게 써보자. forEach!
		System.out.println();
		System.out.print("forEach의 매개변수는 Consumer<T> / void accept(T t)     : ");
		list.forEach((num)->System.out.print(num + " "));
		System.out.println();
		// map은 key, value가 있어서 forEach 사용법이 좀 다르다심 이따가 볼거라심
		
		// remove도 반복문 직접 돌리지 않고 조건을 걸어서 할 수 있음!
		list.removeIf(num->num%2==0);
		System.out.print("removeIf의 매개변수는 Predicate<T> / boolean test(T t)  : ");
		System.out.println(list);
		
		// replace도 String에 메서드가 있는데 컬렉션에서는 replaceAll이 있음
		list.replaceAll(num->num+1);
		System.out.print("replaceAll의 매개변수는 UnaryOperator<T> / T apply(T t) : ");
		System.out.println(list);
		
		// map 람다 사용법!
		HashMap<String, Integer> map = new HashMap<>();
		map.put("고길동", 50);
		map.put("둘리", 10);
		System.out.print("map의 forEach의 매개변수는 BiConsumer<T, U> / void accept(T t, U u) : ");
		map.forEach((key, value)->System.out.print(key + "-" + value + " "));
	}
}
