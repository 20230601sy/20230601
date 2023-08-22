package N02_다형성;

public class S04_HankookTire extends S04_Tire {

	public S04_HankookTire(int maxRotation, String location) {
		super(maxRotation, location);
	}

	@Override
	public boolean roll() {
		acRotation++;
		if(acRotation < maxRotation) {
			System.out.println(location + " 한국타이어의 수명 : " + (maxRotation-acRotation) + " 남음");
			return true;
		} else {
			System.out.println(location + " 한국타이어 터짐");
			return false;
		}
	}
	
}
