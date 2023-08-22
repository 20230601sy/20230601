package N04_생성자;

public class Test01_StudentMain {

	public static void main(String[] args) {
		Test01_Student s = new Test01_Student("홍길동", 1, 1, 100, 60, 76);
		String str = s.info();
		System.out.println(str);
	}

}
