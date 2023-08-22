package N02_다형성;

public class S04_NexenTire extends S04_Tire {
	public S04_NexenTire(int maxRotation, String location) {
		super(maxRotation, location);
	}

	@Override
	public boolean roll() {
		acRotation++;
		if(acRotation < maxRotation) {
			System.out.println(location + " 넥센타이어의 수명 : " + (maxRotation-acRotation) + " 남음");
			return true;
		} else {
			System.out.println(location + " 넥센타이어 터짐");
			return false;
		}
	}
}
