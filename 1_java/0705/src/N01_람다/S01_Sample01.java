package N01_람다;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.BinaryOperator;
import java.util.function.UnaryOperator;

public class S01_Sample01 {

	public static void main(String[] args) {
		BiConsumer<String, Integer> b1 = (str, n) -> System.out.println(str + " " + n);
		System.out.print("BiConsumer b1.accept(\"hello\", 123) : ");
		b1.accept("hello", 123);
		BiFunction<String, Integer, String> b2 = (str, n) -> str + " " + n;
		System.out.print("BiFunction b2.apply(\"hello\", 123)  : ");
		System.out.println(b2.apply("hello", 123));
		BiPredicate<Integer, Integer> b3 = (n1, n2) -> n1>n2;
		System.out.print("BiPredicate b3.test(123, 456)      : ");
		System.out.println(b3.test(123, 456));
		
		BinaryOperator<Integer> bo = (n1, n2) -> n1>n2? n1:n2; // BiFunction<T, U, R>에서 제네릭이 모두 같을 때
		System.out.print("BinaryOperator bo.apply(123, 456)  : ");
		System.out.println(bo.apply(123, 456));
		UnaryOperator<String> uo = str -> str + " 123"; // 마찬가지로 Function<T, R>에서 제네릭이 모두 같을 때
		System.out.print("UnaryOperator uo.apply(\"hello\")    : ");
		System.out.println(uo.apply("hello"));
	}

}
