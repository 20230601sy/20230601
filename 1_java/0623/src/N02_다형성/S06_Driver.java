package N02_다형성;

public class S06_Driver {
	String name;

	public S06_Driver(String name) {
		this.name = name;
	}
	
	public void drive(S06_Vehicle v) {
		System.out.print(name + "님은 ");
		v.run();
	}
}
