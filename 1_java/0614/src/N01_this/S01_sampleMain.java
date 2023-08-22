package N01_this;

public class S01_sampleMain {

	public static void main(String[] args) {
		S01_sample s = new S01_sample();
		s.setName("홍길동");
		System.out.println(s.name);
		System.out.println(s.getName());
	}
}