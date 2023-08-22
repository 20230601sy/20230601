package N02_다형성;

public class S04_Tire {
	int maxRotation;
	int acRotation;
	String location;
	
	public S04_Tire(int maxRotation, String location) {
		this.maxRotation = maxRotation;
		this.location = location;
	}
	
	// 바퀴 회전시키는 메서드
	public boolean roll() {
		acRotation++;
		if(acRotation < maxRotation) {
			System.out.println(location + "의 수명 : " + (maxRotation-acRotation) + " 남음");
			return true;
		} else {
			System.out.println(location + " 타이어 터짐");
			return false;
		}
	}
}
