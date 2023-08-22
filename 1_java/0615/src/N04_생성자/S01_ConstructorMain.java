package N04_생성자;

public class S01_ConstructorMain {

	public static void main(String[] args) {
		S01_Constructor c = new S01_Constructor();
		S01_Constructor c1 = new S01_Constructor("홍길동");
		System.out.println(c1.name + " " + c1.age);
		S01_Constructor c2 = new S01_Constructor("복학생", 19);
		System.out.println(c2.name + " " + c2.age);
	}

}
