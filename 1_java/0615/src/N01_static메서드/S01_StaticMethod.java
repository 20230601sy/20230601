package N01_static메서드;

public class S01_StaticMethod {
	int x;
	static int y ;
	public static void method(int a) { // static public 이런 순도 가능한데, 일반적으로 public을 더 앞에 씀
//		x = x + a; // static 메서드는 멤버변수 사용 못함
		y = y + a; // static 메서드는 static변수는 사용 가능!
		System.out.println("출력 : " + a);
	}
}
