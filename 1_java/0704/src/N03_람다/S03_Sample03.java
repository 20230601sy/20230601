package N03_람다;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class S03_Sample03 {

	public static void main(String[] args) {
		
		Supplier<String> getHello = () -> { // 함수형 인터페이스 공용이기 때문에, 변수이름을 식별 가능하게 하는 편
			return "hello";
		};
		System.out.println(getHello.get());
		
		Consumer<Integer> setLoop = n -> {
			System.out.println("Consumer 연습");
			for(int i=1; i<=n; i++)
				System.out.println(i);
		};
		setLoop.accept(3);
		
		Function<String, Integer> f = str -> Integer.parseInt(str);
		System.out.println(f.apply("123") + 1);
		
		Predicate<Integer> isEven = n -> n%2==0;
		System.out.println(isEven.test(50));
		System.out.println(isEven.test(101));
		
		Predicate<Integer> isOdd = n -> n%2==1;
		System.out.println(isOdd.test(50));
		System.out.println(isOdd.test(101));
	}

}
