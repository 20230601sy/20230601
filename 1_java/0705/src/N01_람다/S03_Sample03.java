package N01_람다;

import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;

class Calc{
	public static int staticMethod(int x, int y) {
		return x+y;
	}
	public int method(int x, int y) {
		return x+y;
	}
}

class LambdaMember {
	String name;
	int age;
	public LambdaMember() {
		System.out.println("기본생성자 호출");
	}
	public LambdaMember(String name) {
		System.out.println("name 생성자 호출");
		this.name = name;
	}
	public LambdaMember(String name, int age) {
		System.out.println("name, age 생성자 호출");
		this.name = name;
		this.age = age;
	}
}
public class S03_Sample03 {

	public static void main(String[] args) {
		Function<String, Integer> f = str -> Integer.parseInt(str);
		/*
		 * 메서드 참조 566p
		 * 함수형인터페이스 변수명 = 클래스명::메서드이름
		 * 함수형인터페이스 변수명 = 참조변수::메서드이름
		 */
		Function<String, Integer> f2 = Integer::parseInt; // ㅋㅋㅋ이클립스에서 기울어져 있으면(parseInt) static 메서드 명쾌하다ㅋㅋㅋ
		BinaryOperator<Integer> f3 = Calc::staticMethod;
//		BinaryOperator<Integer> f4 = Calc::method; // 이건 안돼~
		Calc c = new Calc();
		BinaryOperator<Integer> f4 = c::method; // 이렇게는 돼~
		System.out.println(f3.apply(123, 456) + " " + f4.apply(123, 456));
		/*
		 * 생성자의 메서드 참조 567p
		 * 이건 매개변수 막 다 끌어올 필요가 없어서 편하긴 한듯...
		 * 아니 근데 뭐 어차피 호출할거면 그냥 기존 방식에서 별로 줄지 않는 거 아닌가. 메서드 참조도 참조변수로 메서드참조하는 것도 그닥... 이건 왜 쓰는 거지...ㄷㄷ
		 */
		Supplier<LambdaMember> s 					= LambdaMember :: new; // () -> new LambdaMember();
		Function<String, LambdaMember> func			= LambdaMember :: new; // (name) -> new LambdaMember(name);
		BiFunction<String, Integer, LambdaMember> b = LambdaMember :: new; // (name, age) -> new LambdaMember(name, age);
		LambdaMember m = b.apply("고길동", 50);
	}

}
