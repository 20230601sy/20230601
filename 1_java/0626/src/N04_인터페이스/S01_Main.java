package N04_인터페이스;

public class S01_Main {

	public static void main(String[] args) {
		S01_Dog d = new S01_Dog();
		d.sound();
		
		S01_Bird b = new S01_Bird();
		b.sound();
		b.fly();
		
		S01_Animal a; // 다형성 적용도 된다는 거
		a = new S01_Dog();
		a.sound();
		a = new S01_Bird();
		a.sound();
//		a.fly(); // animal에 들어있는 건 아니기 때문에 직접적인 호출은 불가 
		S01_Flyable a2 = new S01_Bird();
		a2.fly();
		S01_Animal.method();
	}

}
