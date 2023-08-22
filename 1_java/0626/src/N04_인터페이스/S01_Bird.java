package N04_인터페이스;

public class S01_Bird implements S01_Animal, S01_Flyable {

	@Override
	public void fly() {
		System.out.println("새가 날아다님");
	}

	@Override
	public void sound() {
		System.out.println("짹짹");
	}

}
