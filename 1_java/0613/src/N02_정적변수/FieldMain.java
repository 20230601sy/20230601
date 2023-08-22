package N02_정적변수;
public class FieldMain {
	public static void main(String[] args) {
		Field f1 = new Field();
		f1.a = 10;
		f1.b = 20;
		Field f2 = new Field();
		f2.a = 100;
		f2.b = 200;
		// f1.c = 50; // 에러 발생
		System.out.println("a : " + f1.a + " b : " + f1.b);
		System.out.println("a : " + f2.a + " b : " + f2.b);
		System.out.println(Math.PI); // Math 클래스 객체 생성도 안했는데 이건 왜 나올까~static 변수이기 때문! 매번 객체 생성하기 귀찮잖아. 그래서 클래스 변수!
		Field.b = 50; // 이런 식으로도 가능, 이게 되는 이유는 클래스는 실행을 하면 자동으로 올라가기 때문에 인식하고 있음
		System.out.println("a : " + f1.a + " b : " + f1.b);
	}
}